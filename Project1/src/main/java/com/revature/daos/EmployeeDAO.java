package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.JDBCConnection;

public class EmployeeDAO implements GenericDAO<Employee> {
	private Connection conn = JDBCConnection.getConnection();
	private StoryDAO stDao = new StoryDAO();

	@Override
	public Employee add(Employee t) {
		return null;
	}

	@Override
	public Employee getById(Integer id) {
		String sql = "select * from employees where employee_id = ?;";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("employee_id"));
				e.setUsername(rs.getString("employee_username"));
				e.setPassword(rs.getString("employee_password"));
				e.setFirstname(rs.getString("employee_firstname"));
				e.setLastname(rs.getString("employee_lastname"));
				e.setType(rs.getString("employee_type"));

				Integer storyId = rs.getInt("story");
				Integer story2Id = rs.getInt("story2");
				Integer story3Id = rs.getInt("story3");

				if (storyId != null && storyId != 0) {
					e.setStory(stDao.getById(storyId));
				}

				if (story2Id != null && story2Id != 0) {
					e.setStory2(stDao.getById(story2Id));
				}

				if (story3Id != null && story3Id != 0) {
					e.setStory3(stDao.getById(story3Id));
				}

				if (rs.getInt("genre") == 1) {
					e.setGenrename("Fantasy");
				} else {
					e.setGenrename("Si-Fi");
				}

				if (rs.getInt("genre2") == 3) {
					e.setGenrename2("Mystery");
				} else {
					e.setGenrename2("Dystopian");
				}

				if (rs.getInt("genre3") == 5) {
					e.setGenrename3("Horror");
				} else {
					e.setGenrename3("Romance");
				}

				return e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Employee getEmployee(String username, String password) {
		String sql = "select * from employees where employee_username = ? and employee_password = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("employee_id"));
				e.setUsername("employee_username");
				e.setPassword("employee_password");
				e.setFirstname(rs.getString("employee_firstname"));
				e.setLastname(rs.getString("employee_lastname"));
				e.setType(rs.getString("employee_type"));

				Integer storyId = rs.getInt("story");
				Integer story2Id = rs.getInt("story2");
				Integer story3Id = rs.getInt("story3");

				if (storyId != null && storyId != 0) {
					e.setStory(stDao.getById(storyId));
				}

				if (story2Id != null && story2Id != 0) {
					e.setStory2(stDao.getById(story2Id));
				}

				if (story3Id != null && story3Id != 0) {
					e.setStory3(stDao.getById(story3Id));
				}

				if (rs.getInt("genre") == 1) {
					e.setGenrename("Fantasy");
				} else {
					e.setGenrename("Si-Fi");
				}

				if (rs.getInt("genre2") == 3) {
					e.setGenrename2("Mystery");
				} else {
					e.setGenrename2("Dystopian");
				}

				if (rs.getInt("genre3") == 5) {
					e.setGenrename3("Horror");
				} else {
					e.setGenrename3("Romance");
				}

				return e;
			}

		} catch (NullPointerException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getall() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from employees;";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("employee_id"));
				e.setUsername(rs.getString("employee_username"));
				e.setPassword(rs.getString("employee_password"));
				e.setFirstname(rs.getString("employee_firstname"));
				e.setLastname(rs.getString("employee_lastname"));
				e.setType(rs.getString("employee_type"));

				Integer storyId = rs.getInt("story");
				Integer story2Id = rs.getInt("story2");
				Integer story3Id = rs.getInt("story3");

				if (storyId != null && storyId != 0) {
					e.setStory(stDao.getById(storyId));
				}

				if (story2Id != null && story2Id != 0) {
					e.setStory2(stDao.getById(story2Id));
				}

				if (story3Id != null && story3Id != 0) {
					e.setStory3(stDao.getById(story3Id));
				}

				if (rs.getInt("genre") == 1) {
					e.setGenrename("Fantasy");
				} else {
					e.setGenrename("Si-Fi");
				}

				if (rs.getInt("genre2") == 3) {
					e.setGenrename2("Mystery");
				} else {
					e.setGenrename2("Dystopian");
				}

				if (rs.getInt("genre3") == 5) {
					e.setGenrename3("Horror");
				} else {
					e.setGenrename3("Romance");
				}

				employees.add(e);
			}
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void uptate(Employee e) {
		String sql = "update employees set story = ?, story2 = ?, story3 = ? where employee_id =?;";
		try {
			Integer storyId = 0;
			Integer story2Id = 0;
			Integer story3Id = 0;

			storyId = e.getStory().getId();
			if (e.getStory2().getId() != null) {
				story2Id = e.getStory2().getId();
			} else
				story2Id = 0;

			if (e.getStory3().getId() != null) {
				story3Id = e.getStory3().getId();
			} else
				story3Id = 0;

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyId);

			if (story2Id != null && story2Id != 0) {
				ps.setInt(2, story2Id);
			} else {
				ps.setInt(2, 0);
			}

			if (story3Id != null && story3Id != 0) {
				ps.setInt(3, story3Id);
			} else {
				ps.setInt(3, 0);
			}

			ps.setInt(4, e.getId());

			ps.executeUpdate();

		} catch (NullPointerException | SQLException e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public boolean delete(Employee t) {
		return false;
	}

	@Override
	public Employee add(Employee t, Integer id) {
		return null;
	}

}
