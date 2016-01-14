/*@(#)UserService.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankcomm.beijing.hr.dao.UserDao;
import com.bankcomm.beijing.hr.entity.User;
import com.bankcomm.beijing.hr.entity.util.TxManagers;


@Service
public class UserServiceHib {
	private static final String CACHE="userCache";
	@Inject
	private UserDao userDao;
	
	@CacheEvict(value=CACHE,key="#u.username")
	@Transactional(TxManagers.HRRE_TX_MANAGER)
	public void addUser(User u){
		userDao.saveUser(u);
	}
}
