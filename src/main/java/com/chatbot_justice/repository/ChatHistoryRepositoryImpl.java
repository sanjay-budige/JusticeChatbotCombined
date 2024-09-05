package com.chatbot_justice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class ChatHistoryRepositoryImpl implements ChatHistoryRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ChatHistory> getAllChatHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertChatHistory(ChatHistory chatHistory) {
		// TODO Auto-generated method stub
		String sql = "insert into CHAT_HISTORY (name, question, answer, confidence_score) value(?, ?, ?, ?)";
		int count = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, chatHistory.getName());
				ps.setString(2, chatHistory.getQuestion());
				ps.setString(3, chatHistory.getAnswer());
				ps.setFloat(4, chatHistory.getConfidenceScore());
				return ps;
			}
		});
		System.out.println("No. Of records are inserted: " + count);
	}

}
