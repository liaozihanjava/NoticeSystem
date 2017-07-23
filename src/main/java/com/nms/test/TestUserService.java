package com.nms.test;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;

import com.nms.bean.User;
import com.nms.service.UserService;
import com.nms.serviceimpl.UserServiceImpl;

import junit.framework.TestCase;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 上午8:46:07
 * 
 */
public class TestUserService extends UserServiceImpl {
	@Resource
	private UserService userService;

	@Test
	public void testCheckLogin() throws Exception{
		System.out.println(this.userService);

		String name = "ly";
		String password = "111";
		User user = userService.checkLogin(name, password);
		System.out.println(user);
		TestCase.assertTrue(user == null);

	}

	@Test
	public void testShowUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		User new_user = new User();
		new_user.setEmpno(3);
		new_user.setName("hhhhh");
		new_user.setPassword("333");
		new_user.setDeptno(3);
		new_user.setLevel(2);
		new_user.setPhone("111111");
		System.out.println(new_user);
		TestCase.assertTrue(userService.updateUser(new_user));
	}

}
