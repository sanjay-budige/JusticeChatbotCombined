package com.chatbot_justice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatbotComponent {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
