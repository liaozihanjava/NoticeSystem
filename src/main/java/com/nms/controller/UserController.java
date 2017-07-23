package com.nms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nms.bean.Dept;
import com.nms.bean.User;
import com.nms.service.DeptService;
import com.nms.service.UserService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:37:29
 * 
 */

@Controller
@Scope(value = "prototype")
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private DeptService deptService;

	@ResponseBody
	@RequestMapping(value = "/login")
	public String login(@RequestBody User user, Model model, HttpServletRequest request) throws Exception {
		if(request.getSession().getAttribute("user1")!=null){
			return "3";
		}
	    User res_user  = userService.checkLogin(user.getName(), user.getPassword());
		if (res_user != null) {
			Dept dept = deptService.showDept(res_user.getDeptno());
			request.getSession().setAttribute("dept1", dept);
			request.getSession().setAttribute("user1", res_user);
			// model.addAttribute(user);
			return "/sss/page/jump";
		}
		else if(!userService.checkUserExist(user.getName())){
			return "1";
		}
		else{
			return "2";
		}
	}

	@RequestMapping(value = "/show")
	public String show(Model model, HttpServletRequest request) {
		// User user = userService.showUser(empno);
		User user = (User) request.getSession().getAttribute("user1");
		Dept dept = deptService.showDept(user.getDeptno());
		System.out.println(dept);
		// model.addAttribute(dept);
		request.getSession().setAttribute("dept1", dept);
		return "show_basic";
	}

	@RequestMapping(value = "/preshow")
	public String preshow(int empno, Model model, HttpServletRequest request) {
		// User user = userService.showUser(empno);
		User user = (User) request.getSession().getAttribute("user1");
		Dept dept = deptService.showDept(user.getDeptno());
		// model.addAttribute(dept);
		request.getSession().setAttribute("dept1", dept);
		return "/sss/user/show";
	}

	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(@RequestBody User new_user, Model model, HttpServletRequest request) {
		User user1 = (User) request.getSession().getAttribute("user1");
		System.out.println(new_user);
		new_user.setEmpno(user1.getEmpno());
		new_user.setDeptno(user1.getDeptno());
		new_user.setLevel(user1.getLevel());
		new_user.setPassword(user1.getPassword());
		request.getSession().setAttribute("user1", new_user);
		if (userService.updateUser(new_user)) {

			System.out.println(request.getSession().getAttribute("user1"));
			return "/sss/user/show";
		} else {
			return "show_basic";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping(value = "/finddeptusesr")
	public String finddeptusesr(int deptno, Model model, HttpServletRequest request) {
		List<User> user_list = userService.findDeptUser(deptno);
		model.addAttribute("user_list", user_list);
		return "insert_notice";
	}

	@ResponseBody
	@RequestMapping(value = "/insert")
	public String adduser(@RequestBody User user, Model model, HttpServletRequest request) {
		if (userService.checkUserExist(user.getName())) {
			//request.setAttribute("errors", "用户已存在");
			//model.addAttribute("inserterrors", 0);
			//request.getSession().setAttribute("inserterrors", 1);
			return "1";
			//return "/sss/views/add-admin.jsp";
		}
		if (!userService.insertUser(user)) {
			//model.addAttribute("errors", "添加失败，请重新添加");
			//model.addAttribute("inserterrors", 1);
			//request.getSession().setAttribute("inserterrors", 2);

			return "2";
			//return "add-admin";
		} else
			return "/sss/page/jump";
	}
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(@RequestBody User user, Model model, HttpServletRequest request) {
		if(userService.checkUserExistForDelete(user)){
			userService.deleteUser(user.getName());
			return "/sss/page/jump";
		}
		else{
			//System.out.println("sdsfdhgfghjkl;'lkjhgfdghjklkjhgfcd");
			request.getSession().setAttribute("deleteerrors", 1);
			return "/sss/page/jumptoadminmanage";
		}
		
	}
	
	@RequestMapping(value = "/showAll")
	public String showAll(Model model, HttpServletRequest request) {
		// User user = userService.showUser(empno);
		//User user = (User) request.getSession().getAttribute("user1");
		//Dept dept = deptService.showDept(user.getDeptno());
		//System.out.println(dept);
		// model.addAttribute(dept);
		//request.getSession().setAttribute("dept1", dept);
		model.addAttribute("userlist", userService.findAllUser());
		
		return "user_list";//跳到员工显示页面
	}
}
