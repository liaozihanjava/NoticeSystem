package com.nms.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.nms.bean.User;
import com.nms.dao.UserDao;
import com.nms.mapper.UserMapper;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:30:50
 * 
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	// 注解引用Mapper类资源
	@Resource(name = "userMapper")
	private UserMapper userMapper;

	@Override
	public User findUserByName(String name) {

		return userMapper.getUserByName(name);
	}

	@Override
	public User findUserByEmpno(int empno) {
		return userMapper.getUserByEmpno(empno);
	}

	@Override
	public boolean updateUser(User new_user) {
	
		return userMapper.updateUser(new_user);
	}

	@Override
	public List<User> findDeptUser(int deptno) {
		return userMapper.getDeptUser(deptno);
	}

	@Override
	public boolean insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public User checkUserExist(String name) {
		return userMapper.checkUserExist(name);
	}

	@Override
	public boolean checkUserExistForDelete(User user) {
		return userMapper.deleteUser(user.getName());
	}

	@Override
	public boolean deleteUser(String name) {
		return userMapper.deleteUser(name);
	}

	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}

}
