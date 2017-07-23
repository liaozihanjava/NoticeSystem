package com.nms.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nms.bean.User;
import com.nms.dao.UserDao;
import com.nms.service.UserService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:35:05
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	/* 登陆验证 */
	@Override
	public User checkLogin(String name, String password) {

		// 根据用户名实例化用户对象
		User user = userDao.findUserByName(name);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public User showUser(int empno) {
		User user = userDao.findUserByEmpno(empno);
		return user;
	}

	@Override
	public boolean updateUser(User new_user) {
		return userDao.updateUser(new_user);
	}

	@Override
	public List<User> findDeptUser(int deptno) {
		return userDao.findDeptUser(deptno);
	}

	@Override
	public boolean insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public boolean checkUserExist(String name) {
		User user = userDao.checkUserExist(name);
		if(user!=null){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUserExistForDelete(User user) {
		
		if(userDao.checkUserExistForDelete(user)){
			return true;
		}
		else return false;
	}

	@Override
	public boolean deleteUser(String name) {
		return userDao.deleteUser(name);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
}
