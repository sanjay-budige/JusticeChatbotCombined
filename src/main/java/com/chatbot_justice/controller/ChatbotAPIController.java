package com.chatbot_justice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot_justice.service.ChatbotAPIService;

@RestController
public class ChatbotAPIController {

	@Autowired
	private ChatbotAPIService chatbotAPIService;

	@PostMapping(path = "/justice-chatbot")
	public ResponseEntity<String> getchatbotAPI(@RequestBody String question) {

		String answer = chatbotAPIService.callNLPChatbotEngine(question);

		return new ResponseEntity<String>(answer, HttpStatus.OK);
	}

}
