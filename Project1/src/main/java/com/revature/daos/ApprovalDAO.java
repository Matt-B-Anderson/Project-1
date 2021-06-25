package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Approval;
import com.revature.utils.JDBCConnection;

public class ApprovalDAO implements GenericDAO<Approval> {
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Approval add(Approval t) {
		return null;
	}

	@Override
	public Approval getById(Integer id) {
		String sql = "select * from approval where approval_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Approval a = new Approval();
				a.setId(rs.getInt("approval_id"));
				a.setApproval_status(rs.getString("approval_status"));
				a.setApproval_info(rs.getString("approval_info"));
				a.setNumber_of_approves(rs.getInt("number_of_approves"));

				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Approval> getall() {
		return null;
	}

	@Override
	public void uptate(Approval a) {
		String sql = "update approval set approval_status = ?, approval_info= ?, number_of_approves = ? where approval_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getApproval_status());
			ps.setString(2, a.getApproval_info());
			ps.setInt(3, a.getNumber_of_approves());
			ps.setInt(4, a.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(Approval t) {
		return false;
	}

	public Approval getByStatusId(Integer statusId) {
		String sql = "select * from approval where status_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Approval a = new Approval();
				a.setId(rs.getInt("approval_id"));
				a.setApproval_status(rs.getString("approval_status"));
				a.setApproval_info(rs.getString("approval_info"));
				a.setNumber_of_approves(rs.getInt("number_of_approves"));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addApproval(Approval a, Integer statusId) {
		String sql = "insert into approval values (default, ?, ?, ?, ?);";
		System.out.println(statusId);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ps.setString(2, a.getApproval_status());
			ps.setString(3, a.getApproval_info());
			if (a.getNumber_of_approves() != null) {
				ps.setInt(4, a.getNumber_of_approves());
			} else
				ps.setInt(4, 0);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Approval add(Approval t, Integer id) {
		return null;
	}

}
