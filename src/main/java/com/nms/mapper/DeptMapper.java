package com.nms.mapper;

import java.util.List;

import com.nms.bean.Dept;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月26日 下午11:51:28
* 
*/
public interface DeptMapper {
	public Dept getDeptByDeptno(int deptno);
	public List<Dept> showAllDept();
}
