/*@(#)PermissionService.java   2015-12-17 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bankcomm.beijing.hr.mapper.UserMapper;

/**
 * TODO Document PermissionService
 * <p>
 * @version 1.0.0,2015-12-17
 * @author lw
 * @since 1.0.0
 */
@Service
public class PermissionService {
	@Inject
	private UserMapper userMapper;
	public List<String> getUserRoles(String username){
		return userMapper.getUserRoles(username);
	}
	public List<String> getUserPerms(String username){
		return userMapper.getUserStringPermissions(username);
	}
}
