/*@(#)User.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.entity;

import java.io.Serializable;

/**
 * TODO Document User
 * <p>
 * @version 1.0.0,2015-12-1
 * @author lw
 * @since 1.0.0
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	/**
	 * @return The id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param The id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return The username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param The username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return The password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param The password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
