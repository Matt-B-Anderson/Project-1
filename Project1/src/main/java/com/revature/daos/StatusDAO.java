package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Status;
import com.revature.utils.JDBCConnection;

public class StatusDAO implements GenericDAO<Status> {
	private Connection conn = JDBCConnection.getConnection();
	private ApprovalDAO apd = new ApprovalDAO();

	public Status addStatus(Status st, Integer storyid) {
		String sql = "insert into statuses values (default, ?, ?, ?, ?, ?, ?)returning *;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st.getStatus());
			ps.setBoolean(2, st.getPriority());
			ps.setString(3, st.getStatus_date());
			ps.setString(4, st.getGeneral_info());
			ps.setString(5, st.getAuthor_info());
			ps.setString(6, st.getAssistant_info());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Status ss = new Status();
				ss.setId(rs.getInt("story_status_id"));
				return ss;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Status getById(Integer id) {

		return null;
	}

	@Override
	public List<Status> getall() {
		return null;
	}

	@Override
	public void uptate(Status st) {
		String sql = "Update statuses set status =?, priority = ?, status_date = ?,  general_info = ?, author_info = ?, assitant_info = ? where story_status_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, st.getStatus());
			ps.setBoolean(2, st.getPriority());
			ps.setString(3, st.getStatus_date());
			ps.setString(4, st.getGeneral_info());
			ps.setString(5, st.getAuthor_info());
			ps.setString(6, st.getAssistant_info());
			ps.setInt(7, st.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(Status t) {
		return false;
	}

	public Status getStatusByStory(Integer storyId) {
		String sql = "select * from stories left join statuses on stories.story_status = statuses.story_status_id where stories.story_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Status ss = new Status();
				ss.setId(rs.getInt("story_status_id"));
				ss.setStatus(rs.getString("status"));
				ss.setPriority(rs.getBoolean("priority"));
				ss.setStatus_date(rs.getString("status_date"));
				ss.setGeneral_info(rs.getString("general_info"));
				ss.setAuthor_info(rs.getString("author_info"));
				ss.setAssistant_info(rs.getString("assitant_info"));
				ss.setApproval(apd.getByStatusId(ss.getId()));
				return ss;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Status getStatus(Integer statusId) {
		String sql = "select * from statuses where status_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Status ss = new Status();
				ss.setId(rs.getInt("story_status_id"));
				ss.setStatus(rs.getString("status"));
				ss.setPriority(rs.getBoolean("priority"));
				ss.setStatus_date(rs.getString("status_date"));
				ss.setGeneral_info(rs.getString("general_info"));
				ss.setAuthor_info(rs.getString("author_info"));
				ss.setAssistant_info(rs.getString("assitant_info"));
				ss.setApproval(apd.getByStatusId(ss.getId()));
				return ss;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Status add(Status t, Integer id) {
		return null;
	}

	@Override
	public Status add(Status t) {
		return null;
	}

}
