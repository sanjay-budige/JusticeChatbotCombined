package com.chatbot_justice.service;

import java.util.List;

import com.chatbot_justice.repository.User;

public interface UserService {
	User getUserById(int id);

	List<User> getAllUsers();

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(int id);
	
	public User getUserByName(String name, String password);
}
