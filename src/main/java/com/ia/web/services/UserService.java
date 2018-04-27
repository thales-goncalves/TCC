package com.ia.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.web.models.User;
import com.ia.web.repositories.UserRepository;



@Service("userService")
public class UserService {

	@Autowired
    private UserRepository userRepository;
    
    /**
     * Find all Users saved in database
     * @return List with Users
     */
    public List<User> findAllUsers() {
	return userRepository.findAllUsers();
    }

    /**
     * Save a User in database
     * @param user to be saved
     */
    public void saveUser(User user) {

	userRepository.saveUser(user);
    }

    
  /*  public UserDetails findByLogin(String login){

        return userRepository.loadUserByUsername(login)
    }*/

}
