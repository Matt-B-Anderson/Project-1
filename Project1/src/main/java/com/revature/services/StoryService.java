package com.revature.services;

import java.util.List;

import com.revature.models.Story;

public interface StoryService {
	List<Story> getStories();

	Story getStory(Integer id);

	Story updateStory(Story s);

	Story add(Story s, Integer authorid);

}
