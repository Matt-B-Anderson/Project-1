package com.revature.services;

import com.revature.models.Status;

public interface StoryStatusService {
	Status updateStatus(Status st);

	Status getByStoryId(Integer storyid);

	Status getStatus(Integer id);

}
