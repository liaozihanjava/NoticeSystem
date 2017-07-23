package com.nms.service;

import java.util.List;

import com.nms.bean.Draft;

/**
* @author liaozh E-mail:dut_lzh@163.com
* @version 创建时间：2017年6月26日 下午8:34:17
* 
*/
public interface DraftService {

    //根据用户empno查找草稿
    public List<Draft> showNoticeByEmpno(int empno);
    //根据Dno查找草稿
    public Draft showDraftByDno(int dno);
    //增加新草稿
    public boolean addDraft(Draft draft);
    public boolean updateDraft(Draft draft);
    public boolean removeDraft(int dno);
}
