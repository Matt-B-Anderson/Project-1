package com.revature.services;

import com.revature.models.Approval;

public interface ApprovalService {

	Approval getByStoryStatusId(Integer id);

	Approval updateApproval(Approval app);

	Approval getApproval(Integer id);

	void addApproval(Approval zApp, Integer statusId);
}
