package com.nms.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nms.bean.Draft;
import com.nms.dao.DraftDao;
import com.nms.service.DraftService;

/**
 * @author liaozh E-mail:dut_lzh@163.com
 * @version 创建时间：2017年6月27日 下午4:32:37
 * 
 */
@Service
public class DraftServiceImpl implements DraftService {

	@Resource
	private DraftDao draftDao;

	@Override
	public List<Draft> showNoticeByEmpno(int empno) {
		return draftDao.findUnfinishedNoticeByEmpno(empno);
	}

	@Override
	public Draft showDraftByDno(int dno) {
		return draftDao.findDraftByDno(dno);
	}

	@Override
	public boolean addDraft(Draft draft) {
		return draftDao.insertDraft(draft);
	}

	@Override
	public boolean updateDraft(Draft draft) {
		return draftDao.updateDraft(draft);
	}

	@Override
	public boolean removeDraft(int dno) {
		return draftDao.deleteDraft(dno);
	}

}
