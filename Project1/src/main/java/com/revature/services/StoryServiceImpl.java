package com.revature.services;

import java.util.List;

import com.revature.daos.StoryDAO;
import com.revature.models.Story;

public class StoryServiceImpl implements StoryService {
	private StoryDAO stdao = new StoryDAO();

	@Override
	public List<Story> getStories() {
		return stdao.getall();
	}

	@Override
	public Story getStory(Integer id) {
		return stdao.getById(id);
	}

	@Override
	public Story updateStory(Story s) {
		stdao.update(s);
		return stdao.getById(s.getId());
	}

	@Override
	public Story add(Story s, Integer authorid) {
		return stdao.add(s, authorid);
	}

}
