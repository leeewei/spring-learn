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

import com.bankcomm.beijing.hr.annotation.hibernate.HrreTx;
import com.bankcomm.beijing.hr.dao.UserDao;
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
public class UserServiceHib {
	private static final String CACHE="userCache";
	@Inject
	private UserDao userDao;
	
	@CacheEvict(value=CACHE,key="#u.username")
	@HrreTx
	public void addUser(User u){
		userDao.saveUser(u);
	}
}
