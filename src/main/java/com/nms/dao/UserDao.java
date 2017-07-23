package com.nms.dao;

import java.util.List;

import com.nms.bean.User;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:12:40
 * 
 */
public interface UserDao {

	public User findUserByName(String name);
	public User findUserByEmpno(int empno);
	public User checkUserExist(String name);
	public boolean checkUserExistForDelete(User user);
	public boolean updateUser(User new_user);
	public boolean deleteUser(String name);
	public boolean insertUser(User user);
	public List<User> findDeptUser(int deptno);
	public List<User> findAllUser();
}
