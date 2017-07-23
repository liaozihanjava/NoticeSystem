package com.nms.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.nms.bean.Dept;
import com.nms.dao.DeptDao;
import com.nms.mapper.DeptMapper;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午11:58:27
 * 
 */
@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {

	// 注解引用Mapper类资源
	@Resource(name = "deptMapper")
	private DeptMapper deptMapper;

	@Override
	public Dept findDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}

	@Override
	public List<Dept> showAllDept() {
		return deptMapper.showAllDept();
	}

}
