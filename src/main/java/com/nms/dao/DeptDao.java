package com.nms.dao;

import java.util.List;

import com.nms.bean.Dept;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月26日 下午11:56:50
* 
*/
public interface DeptDao {
	public Dept findDeptByDeptno(int deptno);
	public List<Dept> showAllDept();
}
