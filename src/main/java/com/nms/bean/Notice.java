package com.nms.bean;

import java.util.Date;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:06:25
 * 
 */
public class Notice {
	private int nno;
	private int type;
	private int deptno;
	private String content;
	private int status;
	private int empno;
	private String date;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNno() {
		return nno;
	}

	

	@Override
	public String toString() {
		return "Notice [nno=" + nno + ", type=" + type + ", deptno=" + deptno + ", content=" + content + ", status="
				+ status + ", empno=" + empno + ", date=" + date + ", title=" + title + "]";
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
}
