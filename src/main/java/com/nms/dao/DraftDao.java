package com.nms.dao;

import java.util.List;

import com.nms.bean.Draft;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月26日 下午8:12:40
 * 
 */
public interface DraftDao {

	public List<Draft> findUnfinishedNoticeByEmpno(int empno);
	public Draft findDraftByDno(int dno);
	public boolean insertDraft(Draft draft);
	public boolean updateDraft(Draft draft);
	public boolean deleteDraft(int dno);
}
