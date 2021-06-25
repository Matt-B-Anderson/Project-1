package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Status;
import com.revature.models.Story;
import com.revature.utils.JDBCConnection;

public class StoryDAO implements GenericDAO<Story> {

	private Connection conn = JDBCConnection.getConnection();
	private StatusDAO stsd = new StatusDAO();

	@Override
	public Story add(Story s, Integer authorid) {
		String sql = "insert into stories values (default, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";
		Status stat = s.getStory_status();
		String sGenre = s.getGenre();
		String sType = s.getStory_type();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getTitle());
			ps.setString(2, s.getTagline());
			ps.setString(3, s.getDescription());
			ps.setString(4, s.getCompletion_date());

			switch (sGenre) {
			case "Fantasy":
				ps.setInt(5, 1);
				break;
			case "Si-Fi":
				ps.setInt(5, 2);
				break;
			case "Mystery":
				ps.setInt(5, 3);
				break;
			case "Dystopian":
				ps.setInt(5, 4);
				break;
			case "Horror":
				ps.setInt(5, 5);
				break;
			case "Romance":
				ps.setInt(5, 6);
				break;
			default:
				System.out.println("That is not a valid Genre");
				break;
			}

			switch (sType) {
			case "novel":
				ps.setInt(6, 1);
				break;
			case "novella":
				ps.setInt(6, 2);
				break;
			case "short-story":
				ps.setInt(6, 3);
				break;
			case "article":
				ps.setInt(6, 4);
				break;
			default:
				System.out.println("That is not a valid Story Type");
				break;
			}

			ps.setInt(7, 1);
			ps.setInt(8, authorid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer storyId = rs.getInt("story_id");
				Status ss = stsd.addStatus(stat, storyId);
				updateStoryStatus(ss.getId(), storyId);
				System.out.println(getById(storyId) + "updated story");
				return getById(storyId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private void updateStoryStatus(Integer statId, Integer storyId) {
		String sql = "update stories set story_status=? where story_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statId);
			ps.setInt(2, storyId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Story getById(Integer id) {
		String sql = "select * from stories s left join genres g on s.story_genre = g.genre_id left join storytypes st on st.story_type_id = s.story_type where story_id =?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("story_id"));
				s.setTitle(rs.getString("story_title"));
				s.setTagline(rs.getString("story_tagline"));
				s.setDescription(rs.getString("story_description"));
				s.setCompletion_date(rs.getString("story_submit_date"));
				s.setGenre(rs.getString("genre"));
				s.setStory_type(rs.getString("story_type"));
				s.setAurthor_id(rs.getInt("author_id"));
				s.setStory_status(stsd.getStatusByStory(id));
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Story> getall() {
		return null;
	}

	@Override
	public void uptate(Story s) {
		String sql = "update stories set title = ?, tagline = ?, description = ?, completion_date = ?;";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getTitle());
			ps.setString(2, s.getTagline());
			ps.setString(3, s.getDescription());
			ps.setString(4, s.getCompletion_date());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(Story t) {
		return false;
	}

	public List<Story> getStories(Integer id) {
		List<Story> stories = new ArrayList<Story>();
		String sql = "select * from stories s left join genres g on s.story_genre = g.genre_id left join storytypes st on st.story_type_id = s.story_type where s.author_id=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("story_id"));
				s.setTitle(rs.getString("story_title"));
				s.setTagline(rs.getString("story_tagline"));
				s.setDescription(rs.getString("story_description"));
				s.setCompletion_date(rs.getString("story_submit_date"));
				s.setGenre(rs.getString("genre"));
				s.setStory_type(rs.getString("story_type"));
				s.setAurthor_id(rs.getInt("author_id"));
				s.setStory_status(stsd.getStatusByStory(s.getId()));
				stories.add(s);
			}
			return stories;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Story add(Story t) {
		return null;
	}

}
