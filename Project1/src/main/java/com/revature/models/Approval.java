package com.revature.models;

public class Approval {

	private Integer id;
	private String approval_status;
	private String approval_info;
	private Integer number_of_approves;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(Integer id, String approval_status, String approval_info, Integer number_of_approves) {
		super();
		this.id = id;
		this.approval_status = approval_status;
		this.approval_info = approval_info;
		this.number_of_approves = number_of_approves;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}

	public String getApproval_info() {
		return approval_info;
	}

	public void setApproval_info(String approval_info) {
		this.approval_info = approval_info;
	}

	public Integer getNumber_of_approves() {
		return number_of_approves;
	}

	public void setNumber_of_approves(Integer number_of_approves) {
		this.number_of_approves = number_of_approves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approval_info == null) ? 0 : approval_info.hashCode());
		result = prime * result + ((approval_status == null) ? 0 : approval_status.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number_of_approves == null) ? 0 : number_of_approves.hashCode());
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
		Approval other = (Approval) obj;
		if (approval_info == null) {
			if (other.approval_info != null)
				return false;
		} else if (!approval_info.equals(other.approval_info))
			return false;
		if (approval_status == null) {
			if (other.approval_status != null)
				return false;
		} else if (!approval_status.equals(other.approval_status))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number_of_approves == null) {
			if (other.number_of_approves != null)
				return false;
		} else if (!number_of_approves.equals(other.number_of_approves))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Approval [id=" + id + ", approval_status=" + approval_status + ", approval_info=" + approval_info
				+ ", number_of_approves=" + number_of_approves + "]";
	}

}
