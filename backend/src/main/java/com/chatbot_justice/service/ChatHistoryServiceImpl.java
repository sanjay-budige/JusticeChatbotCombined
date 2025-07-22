package com.chatbot_justice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot_justice.repository.ChatHistory;
import com.chatbot_justice.repository.ChatHistoryRepository;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

	@Autowired
	private ChatHistoryRepository chatHistoryRepository;
	
	@Override
	public List<ChatHistory> getAllChatHistory() {
		// TODO Auto-generated method stub
		return chatHistoryRepository.getAllChatHistory();
	}

	@Override
	public void insertChatHistory(ChatHistory chatHistory) {
		// TODO Auto-generated method stub
		chatHistoryRepository.insertChatHistory(chatHistory);
	}

}
