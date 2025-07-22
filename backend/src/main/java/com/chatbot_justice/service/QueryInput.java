package com.chatbot_justice.service;

import com.google.gson.annotations.SerializedName;

class Query{
	@SerializedName("queryInput")
	private QueryInput queryInput;

	public QueryInput getQueryInput() {
		return queryInput;
	}

	public void setQueryInput(QueryInput queryInput) {
		this.queryInput = queryInput;
	}
}

class QueryInput {
	@SerializedName("text")
	private Text text;

	// Getters and setters
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
}

class Text {
	@SerializedName("text")
	private String text;

	@SerializedName("languageCode")
	private String languageCode;

	// Getters and setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
}
