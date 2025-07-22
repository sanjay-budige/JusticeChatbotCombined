package com.chatbot_justice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot_justice.dailogflow.Chatbot;
import com.chatbot_justice.dailogflow.DialogflowResponse;
import com.chatbot_justice.repository.ChatHistory;
import com.chatbot_justice.repository.User;
import com.chatbot_justice.service.ChatHistoryService;
import com.chatbot_justice.service.ChatbotAPIService;
import com.chatbot_justice.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/justice")
public class ChatbotAPIController {

	@Autowired
	private ChatbotAPIService chatbotAPIService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChatHistoryService chatHistoryService;

	@PostMapping(path = "/justice-chatbot")
	public ResponseEntity<Chatbot> getchatbotAPI(@RequestBody Chatbot chatbot) {

		DialogflowResponse answer = chatbotAPIService.callNLPChatbotEngine(chatbot);
		chatbot.setAnswer(answer.getQueryResult().getFulfillmentText());
		chatbot.setConfidenceScore(answer.getQueryResult().getIntentDetectionConfidence());
		
		
		//Insert chat history
		ChatHistory chatHistory = new ChatHistory(); 
		chatHistory.setName("SYSTEM");
		chatHistory.setQuestion(chatbot.getQuestion());
		chatHistory.setAnswer(chatbot.getAnswer());
		chatHistory.setConfidenceScore(chatbot.getConfidenceScore());
		chatHistoryService.insertChatHistory(chatHistory);
		
		return new ResponseEntity<Chatbot>(chatbot, HttpStatus.OK);
	}

	@PostMapping(path = "/justice-chatbot1")
	public ResponseEntity<String> getchatbotAPI1(@RequestBody String question) {
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}

	@PostMapping(path = "/insertUser")
	public ResponseEntity<String> insertUser(@RequestBody User user) {
		userService.insertUser(user);
		return new ResponseEntity<String>("User is Inserted successfully!", HttpStatus.OK);
	}

	@GetMapping(path = "/getUser")
	public ResponseEntity<User> getUser(@RequestParam int id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping(path = "/getUserByName")
	public ResponseEntity<User> gettUserByName(@RequestParam String name, @RequestParam String password) {
		User user = userService.getUserByName(name, password);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
