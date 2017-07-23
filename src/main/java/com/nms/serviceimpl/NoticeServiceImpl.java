package com.nms.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nms.bean.Notice;
import com.nms.dao.NoticeDao;
import com.nms.service.NoticeService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午1:00:34
 * 
 */
@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeDao noticeDao;

	@Override
	public List<Notice> showNoticeByEmpno(int empno) {
		List<Notice> list = noticeDao.findNoticeByEmpno(empno);
		return list;
	}

	@Override
	public boolean addNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}

	@Override
	public List<Notice> showNoticeByDeptno(int deptno) {
		List<Notice> list = noticeDao.findNoticeByDeptno(deptno);
		return list;
	}

	@Override
	public boolean removeNotice(int nno) {
		return noticeDao.deleteNotice(nno);
	}

	@Override
	public Notice showNoticeDetail(int nno) {
		return noticeDao.showNoticeDetail(nno);
	}

	@Override
	public List<Notice> showAllNotices(int empno, int deptno) {
		if(deptno==0){
			return noticeDao.showAllNoticesBoss();
		}
		else{
		return noticeDao.showAllNotices(empno, deptno);
		}
	}

	@Override
	public boolean updateNoticeStatus(int nno) {
		
		return noticeDao.updateNoticeStatus(nno);
	}

	@Override
	public List<Notice> showUnNotices() {
		return noticeDao.showUnNotices();
	}


}
