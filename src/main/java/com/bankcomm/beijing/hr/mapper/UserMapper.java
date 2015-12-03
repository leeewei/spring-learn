/*@(#)UserMapper.java   2015-12-1 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Update("update user set password=#{param2} where username=#{param1}")
	void updatePwd(String username,String newPwd);
	void addUser(User u);
	@Delete("delete from user where username=#{username}")
	void deleteUser(String username);
}
