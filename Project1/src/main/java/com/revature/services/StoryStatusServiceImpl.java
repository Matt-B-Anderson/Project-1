package com.revature.services;

import com.revature.daos.StatusDAO;
import com.revature.models.Status;

public class StoryStatusServiceImpl implements StoryStatusService {
	private StatusDAO stdao = new StatusDAO();

	@Override
	public Status updateStatus(Status st) {
		stdao.uptate(st);
		return stdao.getById(st.getId());
	}

	@Override
	public Status getByStoryId(Integer storyid) {
		return stdao.getStatusByStory(storyid);
	}

	@Override
	public Status getStatus(Integer id) {
		return stdao.getStatus(id);
	}

}
