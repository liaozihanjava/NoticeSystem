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
import com.nms.bean.Draft;
import com.nms.bean.Notice;
import com.nms.bean.User;
import com.nms.service.DeptService;
import com.nms.service.DraftService;
import com.nms.service.NoticeService;
import com.nms.service.UserService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午16:37:29
 * 
 */

@Controller
@Scope(value = "prototype")
@RequestMapping("/draft")
public class DraftController {
	@Resource
	private NoticeService noticeService;
	@Resource
	private UserService userService;
	@Resource
	private DeptService deptService;
	@Resource
	private DraftService draftService;

	@RequestMapping(value = "/showonesdraft")
	public String showonesdraft(int empno, Model model, HttpServletRequest request) {
		Dept dept = deptService.showDept(empno);

		request.getSession().setAttribute("dept1", dept);
		List<Draft> draft_list = new ArrayList<Draft>();
		draft_list = draftService.showNoticeByEmpno(empno);
		model.addAttribute("draft_list", draft_list);
		return "personal_draftlist";
	}

	@RequestMapping(value = "/detail")
	public String detail(int dno, Model model, HttpServletRequest request) {
		Draft draft = draftService.showDraftByDno(dno);
		User user = (User) request.getSession().getAttribute("user1");
		Dept dept = deptService.showDept(user.getDeptno());
		request.getSession().setAttribute("dept1", dept);
		model.addAttribute("draft", draft);
		List<User> user_list = userService.findDeptUser(dept.getDeptno());
		model.addAttribute("user_list", user_list);
		model.addAttribute("dno", dno);
		request.getSession().setAttribute("dno", dno);
		System.out.println("draft:" + draft);
		return "personal_draft_detail";
	}

	@ResponseBody
	@RequestMapping(value = "/edit")
	public String edit(@RequestBody Draft draft, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user1");
		draft.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		/*
		 * Draft new_Draft = new Draft(); new_Draft.setDno(draft.getDno());
		 * new_Draft.setEmpno(user.getEmpno());
		 * new_Draft.setContent(draft.getContent());
		 * System.out.println(new_Draft);
		 */
		draftService.updateDraft(draft);
		/*
		 * User flaguser = (User) request.getSession().getAttribute("user1");
		 * int flag = flaguser.getLevel();
		 */
		return "/sss/page/jump";
		// return "personal_draftlist";
	}

	@RequestMapping(value = "/delete")
	public String delete(int dno, Model model, HttpServletRequest request) {
		System.out.println(dno);
		draftService.removeDraft(dno);
		User flaguser = (User) request.getSession().getAttribute("user1");
		int flag = flaguser.getLevel();
		return "index_" + flag;
		// return "personal_draftlist";
	}

	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(@RequestBody Draft draft, Model model, HttpServletRequest request) {
		draft.setEmpno(((User) request.getSession().getAttribute("user1")).getEmpno());
		draft.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		draftService.addDraft(draft);
		return "/sss/page/jump";
		// return "personal_draftlist";
	}
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(@RequestBody Draft draft, Model model, HttpServletRequest request) {
		draft.setEmpno(((User) request.getSession().getAttribute("user1")).getEmpno());
		draft.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		int dno = (int)request.getSession().getAttribute("dno");
		draft.setDno(dno);
		draftService.updateDraft(draft);
		return "/sss/page/jump";
		// return "personal_draftlist";
	}

	@RequestMapping(value = "/deploy", method = RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Notice notice, Model model, HttpServletRequest request) {
		// System.out.println(notice);
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
			int dno = (int)request.getSession().getAttribute("dno");
			 draftService.removeDraft(dno);
			 request.getSession().setAttribute("dno", null);
		} else {
			System.out.println("fail");
		}
		return "/sss/notice/showonesnotice";
	}

}
