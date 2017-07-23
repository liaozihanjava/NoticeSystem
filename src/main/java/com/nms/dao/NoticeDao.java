package com.nms.dao;

import java.util.List;

import com.nms.bean.Notice;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:12:40
 * 
 */
public interface NoticeDao {

	public List<Notice> findNoticeByEmpno(int empno);
	public List<Notice> findNoticeByDeptno(int deptno);
	public boolean insertNotice(Notice notice);
	public boolean deleteNotice(int nno);
	public Notice showNoticeDetail(int nno);
	public List<Notice> showAllNotices(int empno,int deptno);
	public List<Notice> showUnNotices();
	public boolean updateNoticeStatus(int nno);
	public List<Notice> showAllNoticesBoss();

}
