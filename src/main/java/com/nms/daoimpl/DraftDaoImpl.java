package com.nms.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.nms.bean.Draft;
import com.nms.dao.DraftDao;
import com.nms.mapper.DraftMapper;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午4:29:02
 * 
 */
@Repository("draftDao")
public class DraftDaoImpl implements DraftDao {

	@Resource(name = "draftMapper")
	private DraftMapper draftMapper;

	@Override
	public List<Draft> findUnfinishedNoticeByEmpno(int empno) {

		return draftMapper.getUnfinishedNoticeByEmpno(empno);
	}

	@Override
	public Draft findDraftByDno(int dno) {
		return draftMapper.getDraftByDno(dno);
	}

	@Override
	public boolean insertDraft(Draft draft) {
		return draftMapper.insertDraft(draft);
	}

	@Override
	public boolean updateDraft(Draft draft) {
		return draftMapper.updateDraft(draft);
	}

	@Override
	public boolean deleteDraft(int dno) {
		return draftMapper.deleteDraft(dno);
	}

}
