package com.chatbot_justice.repository;

import java.sql.Date;
import java.sql.Timestamp;

public class ChatHistory {
	private int id;
	private String name;
	private String question;
	private String answer;
	private Float confidenceScore;

	private Timestamp createdAt;

	private Timestamp updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Float getConfidenceScore() {
		return confidenceScore;
	}

	public void setConfidenceScore(Float confidenceScore) {
		this.confidenceScore = confidenceScore;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}
