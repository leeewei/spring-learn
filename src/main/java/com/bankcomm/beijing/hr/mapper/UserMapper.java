/*@(#)UserMapper.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bankcomm.beijing.hr.entity.User;

/**
 * TODO Document UserMapper
 * <p>
 * 
 * @version 1.0.0,2015-12-1
 * @author lw
 * @since 1.0.0
 */
public interface UserMapper {
	User getUser(String username);

	List<User> getUserList();

	@Select("select * from User where username=#{username}")
	User getUserAnnotation(String username);
}
