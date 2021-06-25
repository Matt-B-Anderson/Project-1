package com.revature.models;

public class Story {

	private Integer id;
	private String title;
	private String tagline;
	private String description;
	private String completion_date;
	private String genre;
	private String story_type;
	private Status story_status;
	private Integer aurthor_id;

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Story(Integer id, String title, String tagline, String description, String completion_date, String genre,
			String story_type, Status story_status, Integer aurthor_id) {
		super();
		this.id = id;
		this.title = title;
		this.tagline = tagline;
		this.description = description;
		this.completion_date = completion_date;
		this.genre = genre;
		this.story_type = story_type;
		this.story_status = story_status;
		this.aurthor_id = aurthor_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompletion_date() {
		return completion_date;
	}

	public void setCompletion_date(String completion_date) {
		this.completion_date = completion_date;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getStory_type() {
		return story_type;
	}

	public void setStory_type(String story_type) {
		this.story_type = story_type;
	}

	public Status getStory_status() {
		return story_status;
	}

	public void setStory_status(Status story_status) {
		this.story_status = story_status;
	}

	public Integer getAurthor_id() {
		return aurthor_id;
	}

	public void setAurthor_id(Integer aurthor_id) {
		this.aurthor_id = aurthor_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aurthor_id == null) ? 0 : aurthor_id.hashCode());
		result = prime * result + ((completion_date == null) ? 0 : completion_date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((story_status == null) ? 0 : story_status.hashCode());
		result = prime * result + ((story_type == null) ? 0 : story_type.hashCode());
		result = prime * result + ((tagline == null) ? 0 : tagline.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (aurthor_id == null) {
			if (other.aurthor_id != null)
				return false;
		} else if (!aurthor_id.equals(other.aurthor_id))
			return false;
		if (completion_date == null) {
			if (other.completion_date != null)
				return false;
		} else if (!completion_date.equals(other.completion_date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (story_status == null) {
			if (other.story_status != null)
				return false;
		} else if (!story_status.equals(other.story_status))
			return false;
		if (story_type == null) {
			if (other.story_type != null)
				return false;
		} else if (!story_type.equals(other.story_type))
			return false;
		if (tagline == null) {
			if (other.tagline != null)
				return false;
		} else if (!tagline.equals(other.tagline))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", tagline=" + tagline + ", description=" + description
				+ ", completion_date=" + completion_date + ", genre=" + genre + ", story_type=" + story_type
				+ ", story_status=" + story_status + ", aurthor_id=" + aurthor_id + "]";
	}

}
