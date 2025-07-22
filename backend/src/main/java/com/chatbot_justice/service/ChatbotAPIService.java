package com.chatbot_justice.service;

import com.chatbot_justice.dailogflow.Chatbot;
import com.chatbot_justice.dailogflow.DialogflowResponse;

public interface ChatbotAPIService {

	public DialogflowResponse callNLPChatbotEngine(Chatbot chatbot);
}
