/*@(#)User.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * TODO Document User
 * <p>
 * @version 1.0.0,2015-12-1
 * @author lw
 * @since 1.0.0
 */
@XmlRootElement
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	/**
	 * @return The id
	 */
	@XmlElement
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
	@XmlElement
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
	@JsonIgnore
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
