package com.revature.services;

import com.revature.daos.ApprovalDAO;
import com.revature.models.Approval;

public class ApprovalServiceImpl implements ApprovalService {
	private ApprovalDAO apDao = new ApprovalDAO();

	@Override
	public Approval updateApproval(Approval app) {
		apDao.uptate(app);
		return apDao.getById(app.getId());
	}

	@Override
	public Approval getByStoryStatusId(Integer id) {
		return apDao.getByStatusId(id);
	}

	@Override
	public Approval getApproval(Integer id) {
		return apDao.getById(id);
	}

	@Override
	public void addApproval(Approval app, Integer statusId) {
		apDao.addApproval(app, statusId);
	}

}
