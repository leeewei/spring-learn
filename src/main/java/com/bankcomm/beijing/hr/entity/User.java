/*@(#)User.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * TODO Document User
 * <p>
 * @version 1.0.0,2015-12-1
 * @author lw
 * @since 1.0.0
 */
@XmlRootElement
@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	/**
	 * @return The id
	 */
	@XmlElement
	@Id
	@GeneratedValue(generator="idGenerator")
	/*hibernate 提供的uuid生成器*/
	@GenericGenerator(name="idGenerator", strategy="uuid") 
	@Column(name="id",length=32,nullable=false,unique=true)
/*	通过主键表生成主键 jpa提供的生成器
 * @TableGenerator(
	         name="tab-store",
	         table="ID_GENERATOR_TABLE",
	         pkColumnName = "G_KEY",
	         pkColumnValue="EMPLOYEE_PK",
	         valueColumnName = "G_VALUE",
	         allocationSize=1
	    )*/
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
	@Column(name="username")
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
	@Column(name="password")
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
