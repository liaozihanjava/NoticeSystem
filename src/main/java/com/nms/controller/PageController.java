package com.nms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nms.bean.Dept;
import com.nms.bean.User;
import com.nms.service.DeptService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月30日 上午10:07:58
 * 
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/page")
public class PageController {

	@Resource
	private DeptService deptService;
	
	@RequestMapping(value = "/jump")
	public String jump(Model model, HttpServletRequest request) {
		int level = ((User)request.getSession().getAttribute("user1")).getLevel();
		return "index_"+level;
	}
	
	
	@RequestMapping(value = "/jumptoadminmanage")
	public String jumptoadminmanage(Model model, HttpServletRequest request) {
		//System.out.println("pageController:"+request.getAttribute("errors"));
		List<Dept> dept_list = deptService.showAllDept();
		model.addAttribute("dept_list", dept_list);
		return "add-admin";
	}
	

}
