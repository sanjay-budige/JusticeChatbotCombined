package com.chatbot_justice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot_justice.repository.User;
import com.chatbot_justice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userRepository.insertUser(user);

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByName(String name, String password) {
		// TODO Auto-generated method stub
		return userRepository.getUserByName(name, password);
	}

}
