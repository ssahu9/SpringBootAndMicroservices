package com.sumit.rest.webservices.restfulwebservices.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.rest.webservices.restfulwebservices.UserService;
import com.sumit.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.sumit.rest.webservices.restfulwebservices.model.UserModel;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="user")
	public List<UserModel> getUsers() {
		return userService.getUser();
	}
	
	@PostMapping(path="user")
	public ResponseEntity<Object> saveUser(UserModel userModel ){
		UserModel u = userService.saveUser(userModel);
		return ResponseEntity.created(null).build();
		
	}
	
	@GetMapping(path="/user/{id}")
	public UserModel getUser(@PathVariable Integer id) {
		System.out.println(id);
		UserModel u = userService.getUser(id);
		if(u==null)
			throw new UserNotFoundException("user not found for "+id);
		else
			return u;
		
	}
	
}
