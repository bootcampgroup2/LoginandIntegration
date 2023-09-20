package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exception.CustomException;
import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		return userList;
	}
	
	public User getUser(String email) {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			return user;
		}
		else {
			throw new Error("User not exists");
		}
	}
	
	public boolean checkUser(String email)  {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			return false;
		}else {
			return true;
		}

	}
	
	public void addUser(User user) throws CustomException {
		
		if(checkUser(user.getEmail())) {
			String password = user.getPassword();
			String encodedPassword = passwordEncoder.encode(password);
			user.setPassword(encodedPassword);
			userRepository.save(user);
		}else {
			throw new CustomException("email already exists");
		}
		
	}
	
	public void deleteUser(String username) {
		
		userRepository.deleteById(username);
		
	}
}
