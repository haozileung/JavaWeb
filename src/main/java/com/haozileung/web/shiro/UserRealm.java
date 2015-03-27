package com.haozileung.web.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException(
					"PrincipalCollection method argument cannot be null.");
		}
		String username = (String) getAvailablePrincipal(principals);
		System.out.println("-------------------" + username);// 输出的其实是用户id

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/* 以下可以从数据库获取用户的角色以及权限信息，获取到的信息添加入info即可 */
		// // 增加自定义角色
		// if (null != userInfo.getRoleList()) {
		// for (RoleInfo roleInfo : userInfo.getRoleList()) {
		// if (null != roleInfo.getName()
		// && !"".equals(roleInfo.getName())) {
		// info.addRole(roleInfo.getName());
		// }
		// }
		// }
		// if (null != userInfo.getModuleInfo()) {
		// for (ModuleInfo moduleInfo : userInfo.getModuleInfo()) {
		// if (null != moduleInfo.getGuid()
		// && !"".equals(moduleInfo.getGuid())) {
		// info.addStringPermission(moduleInfo.getGuid());
		// }
		// }
		// }

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// String username = (String) token.getPrincipal();
		// User user = userService.findByUsername(username);
		// if(user == null) {
		// throw new UnknownAccountException();//没找到帐号
		// }
		// if(Boolean.TRUE.equals(user.getLocked())) {
		// throw new LockedAccountException(); //帐号锁定
		// }
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				"", "",
				// user.getUsername(), //用户名
				// user.getPassword(), //密码
				// ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}
}
