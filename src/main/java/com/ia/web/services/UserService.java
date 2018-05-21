package com.ia.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ia.web.models.User;
import com.ia.web.repositories.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	public void saveUser(User user) {

		userRepository.saveUser(user);
	}

	public UserDetails findByLogin(String login) {

		return userRepository.loadUserByUsername(login);
	}

}
