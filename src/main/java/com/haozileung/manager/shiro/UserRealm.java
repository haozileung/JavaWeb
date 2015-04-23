package com.haozileung.manager.shiro;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.User;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private JdbcDao jdbcDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException(
					"PrincipalCollection method argument cannot be null.");
		}
		String email = (String) principals.getPrimaryPrincipal();
		if (Strings.isNullOrEmpty(email)) {
			return null;
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> roleNames = jdbcDao
				.getJdbcTemplate()
				.queryForList(
						"SELECT	r.`name` FROM role r LEFT JOIN user_role ur ON r.id = ur.role_id LEFT JOIN USER u ON ur.user_id = u.id WHERE	r. STATUS = 0 AND u.email = ?",
						new Object[] { email }, String.class);
		Set<String> roles = Sets.newConcurrentHashSet(roleNames);
		List<String> resourceCode = jdbcDao
				.getJdbcTemplate()
				.queryForList(
						"SELECT r.`code` FROM resource r LEFT JOIN role_resource rr ON r.id = rr.resource_id LEFT JOIN user_role ur ON ur.role_id = rr.role_id LEFT JOIN `user` u ON u.id = ur.user_id WHERE r.`status` = 0 AND u.email = ?",
						new Object[] { email }, String.class);
		info.setRoles(roles);
		Set<String> permissions = Sets.newConcurrentHashSet(resourceCode);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String email = (String) token.getPrincipal();
		User user = jdbcDao.querySingleResult(Criteria.create(User.class)
				.where("email", new Object[] { email }));
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		if (user.getStatus() == null || user.getStatus() == 1) {
			throw new LockedAccountException(); // 帐号锁定
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getEmail(), user.getPassword(), getName());
		return authenticationInfo;
	}
}
