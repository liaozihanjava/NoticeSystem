package com.nms.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nms.bean.Dept;
import com.nms.dao.DeptDao;
import com.nms.service.DeptService;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月27日 上午12:02:42
* 
*/

@Service
public class DeptServiceImpl implements DeptService {


	@Resource
    private DeptDao deptDao;
	
	@Override
	public Dept showDept(int deptno) {
		
		return deptDao.findDeptByDeptno(deptno);
	}

	@Override
	public List<Dept> showAllDept() {
		return deptDao.showAllDept();
	}

}
