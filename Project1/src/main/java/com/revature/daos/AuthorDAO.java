package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Author;
import com.revature.utils.JDBCConnection;

public class AuthorDAO implements GenericDAO<Author> {
	private Connection conn = JDBCConnection.getConnection();
	StoryDAO std = new StoryDAO();

	@Override
	public Author add(Author t) {
		return null;
	}

	@Override
	public Author getById(Integer id) {
		String sql = "select * from authors where author_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("author_id"));
				a.setUsername(rs.getString("author_username"));
				a.setPass(rs.getString("author_pass"));
				a.setPoints(rs.getInt("author_points"));
				a.setFirstname(rs.getString("author_firstname"));
				a.setLastname(rs.getString("author_lastname"));
				a.setStories(std.getStories(a.getId()));
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Author getByUsernamePassword(String username, String password) {
		String sql = "select * from authors where author_username =? and author_pass=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("author_id"));
				a.setUsername(rs.getString("author_username"));
				a.setPass(rs.getString("author_pass"));
				a.setPoints(rs.getInt("author_points"));
				a.setFirstname(rs.getString("author_firstname"));
				a.setLastname(rs.getString("author_lastname"));
				a.setStories(std.getStories(a.getId()));
				System.out.println(a);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Author> getall() {
		return null;
	}

	@Override
	public void update(Author a) {
		String sql = "update authors set author_points =? where author_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getPoints());
			ps.setInt(2, a.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean delete(Author t) {
		return false;
	}

	@Override
	public Author add(Author t, Integer id) {
		return null;
	}

}
