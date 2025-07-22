package com.chatbot_justice.repository;

import java.util.List;

public interface ChatHistoryRepository {

	List<ChatHistory> getAllChatHistory();

	void insertChatHistory(ChatHistory chatHistory);

}
