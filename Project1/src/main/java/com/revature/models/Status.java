package com.revature.models;

public class Status {

	private Integer id;
	private String status;
	private Boolean priority;
	private String status_date;
	private String author_info;
	private String general_info;
	private String assistant_info;
	private Approval approval;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(Integer id, String status, Boolean priority, String status_date, String author_info,
			String general_info, String assistant_info, Approval approval) {
		super();
		this.id = id;
		this.status = status;
		this.priority = priority;
		this.status_date = status_date;
		this.author_info = author_info;
		this.general_info = general_info;
		this.assistant_info = assistant_info;
		this.approval = approval;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getPriority() {
		return priority;
	}

	public void setPriority(Boolean priority) {
		this.priority = priority;
	}

	public String getStatus_date() {
		return status_date;
	}

	public void setStatus_date(String status_date) {
		this.status_date = status_date;
	}

	public String getAuthor_info() {
		return author_info;
	}

	public void setAuthor_info(String author_info) {
		this.author_info = author_info;
	}

	public String getGeneral_info() {
		return general_info;
	}

	public void setGeneral_info(String general_info) {
		this.general_info = general_info;
	}

	public String getAssistant_info() {
		return assistant_info;
	}

	public void setAssistant_info(String assistant_info) {
		this.assistant_info = assistant_info;
	}

	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + ((assistant_info == null) ? 0 : assistant_info.hashCode());
		result = prime * result + ((author_info == null) ? 0 : author_info.hashCode());
		result = prime * result + ((general_info == null) ? 0 : general_info.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((status_date == null) ? 0 : status_date.hashCode());
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
		Status other = (Status) obj;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (assistant_info == null) {
			if (other.assistant_info != null)
				return false;
		} else if (!assistant_info.equals(other.assistant_info))
			return false;
		if (author_info == null) {
			if (other.author_info != null)
				return false;
		} else if (!author_info.equals(other.author_info))
			return false;
		if (general_info == null) {
			if (other.general_info != null)
				return false;
		} else if (!general_info.equals(other.general_info))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (status_date == null) {
			if (other.status_date != null)
				return false;
		} else if (!status_date.equals(other.status_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + ", priority=" + priority + ", status_date=" + status_date
				+ ", author_info=" + author_info + ", general_info=" + general_info + ", assistant_info="
				+ assistant_info + ", approval=" + approval + "]";
	}

}
