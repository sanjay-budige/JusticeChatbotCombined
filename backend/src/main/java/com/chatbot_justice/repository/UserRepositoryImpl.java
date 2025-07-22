package com.chatbot_justice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserRowMapper());
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user (name, password, email, date_of_birth) value(?, ?, ?, ?)";
		int count = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setDate(4, user.getDateOfBirth());
				return ps;
			}
		});
		System.out.println("No. Of User records are inserted: " + count);

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	private static final class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
	}

	@Override
	public User getUserByName(String name, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user where name = ? and password = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { name, password }, new UserRowMapper());
	}

}
