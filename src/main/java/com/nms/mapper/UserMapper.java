package com.nms.mapper;

import java.util.List;

import com.nms.bean.User;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月26日 下午8:20:52
* 
*/
public interface UserMapper {
	public User getUserByName(String name);
	public User getUserByEmpno(int empno);
	public boolean updateUser(User user);
	public boolean deleteUser(String name);
	public List<User> getDeptUser(int deptno);
	public boolean insertUser(User user);
	public User checkUserExist(String name);
	public User checkUserExistForDelete(User user);
	public List<User> findAllUser();
}
