package com.chatbot_justice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.chatbot_justice.*")
@EnableAutoConfiguration
@SpringBootApplication
public class ChatbotJusticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotJusticeApplication.class, args);
	}

}
