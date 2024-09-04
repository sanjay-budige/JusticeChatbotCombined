package com.chatbot_justice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot_justice.dailogflow.Chatbot;
import com.chatbot_justice.dailogflow.DialogflowResponse;
import com.chatbot_justice.service.ChatbotAPIService;

@CrossOrigin(origins = "*")
@RestController
public class ChatbotAPIController {

	@Autowired
	private ChatbotAPIService chatbotAPIService;

	@PostMapping(path = "/justice-chatbot")
	public ResponseEntity<Chatbot> getchatbotAPI(@RequestBody Chatbot chatbot) {

		DialogflowResponse answer = chatbotAPIService.callNLPChatbotEngine(chatbot);
		chatbot.setAnswer(answer.getQueryResult().getFulfillmentText());
		chatbot.setConfidenceScore(answer.getQueryResult().getIntentDetectionConfidence());
		return new ResponseEntity<Chatbot>(chatbot, HttpStatus.OK);
	}

	@PostMapping(path = "/justice-chatbot1")
	public ResponseEntity<String> getchatbotAPI1(@RequestBody String question) {
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}

}
