package com.nms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nms.bean.Notice;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午12:45:16
 * 
 */
public interface NoticeMapper {

	public List<Notice> getNoticeByEmpno(int empno);

	public List<Notice> getNoticeByDeptno(int deptno);

	public boolean insertNotice(Notice notice);
	public boolean deleteNotice(int nno);
	public boolean updateNoticeStatus(int nno);
	public Notice showNoticeDetail(int nno);
	public List<Notice> showAllNotices(@Param("empno")int empno,@Param("deptno")int deptno);
	public List<Notice> showUnNotices();
	public List<Notice> showAllNoticesBoss();


}
