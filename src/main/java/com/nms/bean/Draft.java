package com.nms.bean;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:10:38
 * 
 */
public class Draft {

	private int dno;
	private int empno;
	private String content;
	private String title;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Draft [dno=" + dno + ", empno=" + empno + ", content=" + content + ", title=" + title + ", date=" + date
				+ "]";
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
