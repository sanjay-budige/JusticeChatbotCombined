package com.chatbot_justice.service;

import java.util.List;

import com.chatbot_justice.repository.ChatHistory;

public interface ChatHistoryService {

	List<ChatHistory> getAllChatHistory();

	void insertChatHistory(ChatHistory chatHistory);
}
