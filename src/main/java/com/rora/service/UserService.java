package com.rora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rora.model.User;
import com.rora.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
	 private final UserRepository userRepository;
	 
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	
	
	 

}
