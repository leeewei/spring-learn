/*@(#)UserDaoImpl.java   2016-1-8 
 * Copy Right 2016 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bankcomm.beijing.hr.annotation.hibernate.HrreTx;
import com.bankcomm.beijing.hr.entity.User;

/**
 * TODO Document UserDaoImpl
 * <p>
 * @version 1.0.0,2016-1-8
 * @author lw
 * @since 1.0.0
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@PersistenceContext 
	 private EntityManager em; 

	@Override
	public User saveUser(User user) {
		em.persist(user);
		return user;
	}

}
