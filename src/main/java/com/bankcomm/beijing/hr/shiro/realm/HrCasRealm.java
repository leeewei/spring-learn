package com.bankcomm.beijing.hr.shiro.realm;

import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bankcomm.beijing.hr.service.PermissionService;

public class HrCasRealm extends CasRealm {
	Logger logger = LoggerFactory.getLogger(CasRealm.class);
	@Inject
	private PermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal(); // 从这里可以从cas
		logger.debug("cas-shiro username:" + username);
		// 也可以从 Subject subject = SecurityUtils.getSubject();
		// return (String)subject.getPrincipals().asList().get(0); 中取得，因为已经整合后
		// cas 交给了 shiro-cas
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		List<String> codes = permissionService.getUserPerms(username);
		authorizationInfo.addStringPermissions(codes);
		authorizationInfo.addRoles(permissionService.getUserRoles(username));
		return authorizationInfo;

	}
}