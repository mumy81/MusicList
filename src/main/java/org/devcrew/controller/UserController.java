package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.User;
import org.devcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@GetMapping("/all")
	public List<User> getAllUser(){
		return userRepository.findAll();		
	}
	@PostMapping("/add")
	public User saveUser(@RequestBody User user){
		return userRepository.save(user);		
	}
}
