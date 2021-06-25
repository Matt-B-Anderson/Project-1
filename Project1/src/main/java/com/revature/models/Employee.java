package com.revature.models;

public class Employee {

	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String type;
	private String genrename;
	private String genrename2;
	private String genrename3;
	private Story story;
	private Story story2;
	private Story story3;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String username, String password, String firstname, String lastname, String type,
			String genrename, String genrename2, String genrename3, Story story, Story story2, Story story3) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.genrename = genrename;
		this.genrename2 = genrename2;
		this.genrename3 = genrename3;
		this.story = story;
		this.story2 = story2;
		this.story3 = story3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenrename() {
		return genrename;
	}

	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}

	public String getGenrename2() {
		return genrename2;
	}

	public void setGenrename2(String genrename2) {
		this.genrename2 = genrename2;
	}

	public String getGenrename3() {
		return genrename3;
	}

	public void setGenrename3(String genrename3) {
		this.genrename3 = genrename3;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Story getStory2() {
		return story2;
	}

	public void setStory2(Story story2) {
		this.story2 = story2;
	}

	public Story getStory3() {
		return story3;
	}

	public void setStory3(Story story3) {
		this.story3 = story3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((genrename == null) ? 0 : genrename.hashCode());
		result = prime * result + ((genrename2 == null) ? 0 : genrename2.hashCode());
		result = prime * result + ((genrename3 == null) ? 0 : genrename3.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		result = prime * result + ((story2 == null) ? 0 : story2.hashCode());
		result = prime * result + ((story3 == null) ? 0 : story3.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (genrename == null) {
			if (other.genrename != null)
				return false;
		} else if (!genrename.equals(other.genrename))
			return false;
		if (genrename2 == null) {
			if (other.genrename2 != null)
				return false;
		} else if (!genrename2.equals(other.genrename2))
			return false;
		if (genrename3 == null) {
			if (other.genrename3 != null)
				return false;
		} else if (!genrename3.equals(other.genrename3))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		if (story2 == null) {
			if (other.story2 != null)
				return false;
		} else if (!story2.equals(other.story2))
			return false;
		if (story3 == null) {
			if (other.story3 != null)
				return false;
		} else if (!story3.equals(other.story3))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", type=" + type + ", genrename=" + genrename + ", genrename2="
				+ genrename2 + ", genrename3=" + genrename3 + ", story=" + story + ", story2=" + story2 + ", story3="
				+ story3 + "]";
	}

}
