package com.haozileung.manager.shiro;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.haozileung.infra.utils.SpringContextUtil;
import com.haozileung.manager.model.security.Resource;
import com.haozileung.manager.model.security.Role;
import com.haozileung.manager.model.security.User;
import com.haozileung.manager.service.security.IResourceService;
import com.haozileung.manager.service.security.IRoleService;
import com.haozileung.manager.service.security.IUserService;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		IRoleService roleService = (IRoleService) SpringContextUtil
				.getBean("roleServiceImpl");
		if (principals == null) {
			throw new AuthorizationException(
					"PrincipalCollection method argument cannot be null.");
		}
		String email = (String) principals.getPrimaryPrincipal();
		if (Strings.isNullOrEmpty(email)) {
			return null;
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Role> rs = roleService.findRoleByUserEmail(email);
		if (rs != null && rs.size() > 0) {
			Set<String> roleCodes = Sets.newHashSet();
			List<Long> roleIds = Lists.newArrayList();
			for (Role r : rs) {
				roleCodes.add(r.getCode());
				roleIds.add(r.getId());
			}
			IResourceService resourceService = (IResourceService) SpringContextUtil
					.getBean("resourceServiceImpl");
			List<Resource> resources = resourceService
					.findResourceByRoleIds(roleIds);
			if (resources != null && resources.size() > 0) {
				Set<String> resourceCodes = Sets.newHashSet();
				for (Resource r : resources) {
					resourceCodes.add(r.getCode());
				}
				info.setStringPermissions(resourceCodes);
			}
			info.setRoles(roleCodes);

		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		IUserService userService = (IUserService) SpringContextUtil
				.getBean("userServiceImpl");
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String email = t.getUsername();
		User user = userService.findUserByEmail(email);
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		if (user.getStatus() == null || user.getStatus() == 1) {
			throw new LockedAccountException(); // 帐号锁定
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getEmail(), user.getPassword(), getName());
		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
