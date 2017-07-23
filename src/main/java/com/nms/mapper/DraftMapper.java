package com.nms.mapper;

import java.util.List;

import com.nms.bean.Draft;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午16:20:52
 * 
 */
public interface DraftMapper {

	public List<Draft> getUnfinishedNoticeByEmpno(int empno);

	public Draft getDraftByDno(int dno);

	public boolean insertDraft(Draft draft);

	public boolean updateDraft(Draft draft);
	
	public boolean deleteDraft(int dno);
}
