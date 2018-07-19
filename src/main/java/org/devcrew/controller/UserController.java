package org.devcrew.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.devcrew.exception.LoginFailedException;
import org.devcrew.model.Credentials;
import org.devcrew.model.User;
import org.devcrew.repository.UserRepository;
import org.devcrew.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/all")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User showUser(@PathVariable("id") long id) {
		return userRepository.findById(id);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User loginUser(@RequestBody Credentials credentials, HttpServletResponse response)
			throws LoginFailedException, UnsupportedEncodingException {
		User resUser = new User();
		if (userServiceImpl.login(credentials.getUsername(), credentials.getPassword()) == true) {
			String token = credentials.getUsername() + ":" + credentials.getPassword();
			String encoding = Base64.getEncoder().encodeToString((token).getBytes("UTF-8"));
			// String encodedToken =
			// Base64.getEncoder().encode(token.getBytes()).toString();
			System.out.println(encoding);
			response.setHeader("token", encoding);
			resUser = userRepository.findByUsername(credentials.getUsername());
		}
			
			return resUser;

		
	}

}
