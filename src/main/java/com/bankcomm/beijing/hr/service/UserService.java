/*@(#)UserService.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bankcomm.beijing.hr.entity.User;
import com.bankcomm.beijing.hr.mapper.UserMapper;

/**
 * TODO Document UserService
 * <p>
 * 
 * @version 1.0.0,2015-12-1
 * @author lw
 * @since 1.0.0
 */
@Service
public class UserService {
	@Inject
	private UserMapper userMapper;

	public User getUser(String username) {
		return userMapper.getUser(username);
	}

	public User getUserAnnotation(String username) {
		return userMapper.getUser(username);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return (List<User>) userMapper.getUserList();
	}
}
