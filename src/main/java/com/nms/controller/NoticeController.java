package com.nms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nms.bean.Dept;
import com.nms.bean.Notice;
import com.nms.bean.User;
import com.nms.service.DeptService;
import com.nms.service.NoticeService;
import com.nms.service.UserService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午13:02:29
 * 
 */

@Controller
@Scope(value = "prototype")
@RequestMapping("/notice")
public class NoticeController {
	@Resource
	private NoticeService noticeService;
	@Resource
	private UserService userService;
	@Resource
	private DeptService deptService;

	@RequestMapping(value = "/showonesnotice")
	public String showonesnotice(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user1");
		Dept dept = deptService.showDept(user.getDeptno());
		request.getSession().setAttribute("dept1", dept);
		List<Notice> list = new ArrayList<Notice>();
		list = noticeService.showNoticeByDeptno(dept.getDeptno());
		model.addAttribute("list", list);
		System.out.println(list);
		return "personal_noticelist";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Notice notice, Model model, HttpServletRequest request) {
		//System.out.println(notice);
		User user = (User) request.getSession().getAttribute("user1");
		Dept dept = deptService.showDept(user.getEmpno());
		request.getSession().setAttribute("dept1", dept);
		notice.setDeptno(user.getDeptno());
		if (user.getLevel() == 1) {
			notice.setStatus(1);
		} else {
			notice.setStatus(0);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		notice.setDate(sdf.format(new Date()));
		if (noticeService.addNotice(notice)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		System.out.println(notice);
		System.out.println();
		return "/sss/notice/showonesnotice";
	}

	@RequestMapping(value = "/delete")
	public String delete(int nno, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user1");
		noticeService.removeNotice(nno);
		return "index_" + user.getEmpno();
	}

	@RequestMapping(value = "/detail")
	public String detail(int nno, Model model, HttpServletRequest request) {
		Notice detail_notice = noticeService.showNoticeDetail(nno);
		model.addAttribute("dname",deptService.showDept(detail_notice.getDeptno()).getDname());
		model.addAttribute("detail_notice", detail_notice);
		return "notice_detail";
	}

	@RequestMapping(value = "/check")
	public String check(int nno, Model model, HttpServletRequest request) {
		Notice check_notice = noticeService.showNoticeDetail(nno);
		model.addAttribute("check_notice", check_notice);
		model.addAttribute("dname",deptService.showDept(check_notice.getDeptno()).getDname());
		return "notice_check_detail";
	}

	@RequestMapping(value = "/showall")
	public String showall(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user1");
		int empno = user.getEmpno();
		int deptno = user.getDeptno();
		List<Notice> notice_list = noticeService.showAllNotices(empno, deptno);
		model.addAttribute("notice_list", notice_list);
		return "notice_list";
	}

	@RequestMapping(value = "/verify")
	public String verify(int nno, Model model, HttpServletRequest request) {
		noticeService.updateNoticeStatus(nno);
		return "index_"+((User)request.getSession().getAttribute("user1")).getLevel();
	}

	@RequestMapping(value = "/showun")
	public String showun(Model model, HttpServletRequest request) {
		List<Notice> unnotice_list = noticeService.showUnNotices();
		System.out.println(unnotice_list);
		model.addAttribute("unnotice_list", unnotice_list);
		return "unnotice_list";
	}

}
