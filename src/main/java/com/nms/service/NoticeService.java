package com.nms.service;

import java.util.List;

import com.nms.bean.Notice;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月26日 下午8:34:17
* 
*/
public interface NoticeService {

    //根据用户empno查找notice
    public List<Notice> showNoticeByEmpno(int empno);
    public List<Notice> showNoticeByDeptno(int deptno);
    public List<Notice> showAllNotices(int empno,int deptno);
    public List<Notice> showUnNotices();
    public boolean addNotice(Notice notice);
    public boolean removeNotice(int nno);
    public boolean updateNoticeStatus(int nno);
    public Notice showNoticeDetail(int nno);
}
