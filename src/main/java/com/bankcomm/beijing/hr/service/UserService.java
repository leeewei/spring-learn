/*@(#)UserService.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private static final String CACHE="userCache";
	@Inject
	private UserMapper userMapper;
	@Cacheable(value="userCache",key="#username")
	public User getUser(String username) {
		return userMapper.getUser(username);
	}
	@Cacheable(value="userCache",key="#username")
	public User getUserAnnotation(String username) {
		return userMapper.getUser(username);
	}
	public List<User> getUserList() {
		return (List<User>) userMapper.getUserList();
	}
	@CacheEvict(value=CACHE,key="#u.username")
	@Transactional
	public void addUser(User u){
		userMapper.addUser(u);
	}
	@CacheEvict(value=CACHE,key="#username")
	@Transactional
	public void changePwd(String username,String newPwd){
		userMapper.updatePwd(username, newPwd);
	}
	@CacheEvict(value=CACHE)
	@Transactional
	public void deleteUser(String username){
		userMapper.deleteUser(username);
	}
}
