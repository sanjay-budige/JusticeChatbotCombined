package com.chatbot_justice.dailogflow;

public class Chatbot {
	private String question;
	private String answer;
	private Float confidenceScore;

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
		confidenceScore = confidenceScore*100;
		this.confidenceScore = confidenceScore;
	}

}
