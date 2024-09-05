package com.chatbot_justice.repository;

import java.util.List;

public interface UserRepository {

	User getUserById(int id);
	
	User getUserByName(String name, String password);

	List<User> getAllUsers();

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(int id);

}
