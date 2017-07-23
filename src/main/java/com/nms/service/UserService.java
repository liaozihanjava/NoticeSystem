package com.nms.service;

import java.util.List;

import com.nms.bean.User;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:34:17
 * 
 */
public interface UserService {

	// 通过用户名及密码核查用户登录
	public User checkLogin(String name, String password);

	// 显示用户信息
	public User showUser(int empno);

	// 显示用户名是否存在
	public boolean checkUserExist(String name);
	// 显示用户是否存在
	public boolean checkUserExistForDelete(User user);

	// 更新用户信息
	public boolean updateUser(User new_user);
	// 删除用户信息
	public boolean deleteUser(String name);

	// 增加新用户
	public boolean insertUser(User user);

	// 显示本部门人员
	public List<User> findDeptUser(int deptno);
	// 显示所有人员
	public List<User> findAllUser();
}
