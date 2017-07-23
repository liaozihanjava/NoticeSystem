package com.nms.service;

import java.util.List;

import com.nms.bean.Dept;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月27日 上午12:01:10
* 
*/
public interface DeptService {

	// 通过用户名及密码核查用户登录
    public Dept showDept(int deptno);
	//显示除老板以外的所有部门
    public List<Dept> showAllDept();
}
