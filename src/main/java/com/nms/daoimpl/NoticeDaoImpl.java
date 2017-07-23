package com.nms.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.nms.bean.Notice;
import com.nms.dao.NoticeDao;
import com.nms.mapper.NoticeMapper;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午12:53:06
 * 
 */
@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> findNoticeByEmpno(int empno) {
		System.out.println("DaoImpl层的list:"+noticeMapper.getNoticeByEmpno(empno));
		return noticeMapper.getNoticeByEmpno(empno);
	}

	@Override
	public boolean insertNotice(Notice notice) {
		return noticeMapper.insertNotice(notice);
	}

	@Override
	public List<Notice> findNoticeByDeptno(int deptno) {
		return noticeMapper.getNoticeByDeptno(deptno);
	}

	@Override
	public boolean deleteNotice(int nno) {
		return noticeMapper.deleteNotice(nno);
	}

	@Override
	public Notice showNoticeDetail(int nno) {
		return noticeMapper.showNoticeDetail(nno);
	}

	@Override
	public List<Notice> showAllNotices(int empno, int deptno) {
		return noticeMapper.showAllNotices(empno, deptno);
	}

	@Override
	public boolean updateNoticeStatus(int nno) {
		return noticeMapper.updateNoticeStatus(nno);
	}

	@Override
	public List<Notice> showUnNotices() {
		return noticeMapper.showUnNotices();
	}

	@Override
	public List<Notice> showAllNoticesBoss() {
		return noticeMapper.showAllNoticesBoss();
	}

}
