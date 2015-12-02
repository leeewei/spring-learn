/*@(#)MyBatisTest.java   2015-12-2 
 * Copy Right 2015 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bankcomm.beijing.hr.mapper.UserMapper;
import com.bankcomm.beijing.hr.service.UserService;

/**
 * TODO Document MyBatisTest
 * <p>
 * @version 1.0.0,2015-12-2
 * @author lw
 * @since 1.0.0
 */
public class MyBatisTest {
	private ApplicationContext ctx;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ctx = new FileSystemXmlApplicationContext("D:\\531\\dev_soft\\eclipse\\workspace\\hr_re\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
	}

	@Test
	public void test() {
		UserService user = (UserService) ctx.getBean("userService");
		System.out.println(user.getUser("user1").getPassword());
		System.out.println(user.getUserList().get(0).getPassword());
		System.out.println(user.getUserAnnotation("user1").getPassword());//invoke the annotation
		UserMapper um = ((SqlSessionFactory)ctx.getBean("sqlSessionFactory")).openSession().getMapper(UserMapper.class);
		System.out.println(um.getUserAnnotation("user1").getPassword());
	}

}
