package com.chatbot_justice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.chatbot_justice.dailogflow.Chatbot;
import com.chatbot_justice.dailogflow.DialogflowResponse;
import com.google.gson.Gson;

@Service
public class ChatbotAPIServiceImpl implements ChatbotAPIService {

	@Autowired
	private RestTemplate restTemplate;

	String nlp_url = "https://dialogflow.googleapis.com/v2/projects/dojchatbot/agent/sessions/84574a7c-5de5-4097-9b47-3490d8a475b4:detectIntent";

	String token_url = "https://oauth2.googleapis.com/token";

	@Value("${chatbot.refresh_token}")
	private String refreshToken;

	@Override
	public DialogflowResponse callNLPChatbotEngine(Chatbot chatbot) {

		Text text = new Text();
		text.setLanguageCode("en");
		text.setText(chatbot.getQuestion()); // SET Question
		QueryInput queryInput = new QueryInput();
		queryInput.setText(text);

		Query query = new Query();
		query.setQueryInput(queryInput);
		
		Gson gson = new Gson();
		String json = gson.toJson(query);
		System.out.println(json);

		// Get token from Google auth token service
		DailoagFlowToken token = generateAccessToken();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", token.getToken_type() + " " + token.getAccess_token());

		// Create the HttpEntity with the body and headers
		HttpEntity<String> request = new HttpEntity<>(json, headers);

		// Make the POST request
		ResponseEntity<DialogflowResponse> response = restTemplate.exchange(nlp_url, HttpMethod.POST, request,
				DialogflowResponse.class);

		// Print the response
		System.out.println(response.getBody());

		// Return response from Dailogflow for response answer
		return response.getBody();
	}

	private DailoagFlowToken generateAccessToken() {

		// Create request body
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
		// This value need to updated whenever you get an error - run python code and
		// update here
		map.add("assertion", refreshToken);
		// Create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		// Call POST API to get the token by passing token, headers and request body
		ResponseEntity<DailoagFlowToken> response = restTemplate.postForEntity(token_url, request,
				DailoagFlowToken.class);

		return response.getBody();
	}

}
