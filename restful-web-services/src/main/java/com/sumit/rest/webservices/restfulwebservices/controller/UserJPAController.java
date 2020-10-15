package com.sumit.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.sumit.rest.webservices.restfulwebservices.UserService;
import com.sumit.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.sumit.rest.webservices.restfulwebservices.model.Post;
import com.sumit.rest.webservices.restfulwebservices.model.UserModel;
import com.sumit.rest.webservices.restfulwebservices.repository.PostRepository;
import com.sumit.rest.webservices.restfulwebservices.repository.UserRepository;

@RestController
@RequestMapping(path="/jpa/")
public class UserJPAController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path="user")
	public List<UserModel> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(path="user")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody UserModel userModel ){
		UserModel u = userRepository.save(userModel);
		return ResponseEntity.created(null).build();
		
	}
	
	@GetMapping(path="/user/{id}")
	public EntityModel<UserModel> getUser(@PathVariable Integer id) {

		Optional<UserModel> u = userRepository.findById(id);
		if(!u.isPresent())
			throw new UserNotFoundException("user not found for "+id);
		
        EntityModel<UserModel> resource = EntityModel.of(u.get());
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		
		return resource;
		
	}
	
	@DeleteMapping(path="/user/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping(path="/user/{id}/post")
	public List<Post> getUserPost(@PathVariable Integer id) {

		Optional<UserModel> u = userRepository.findById(id);
		if(!u.isPresent())
			throw new UserNotFoundException("user not found for "+id);
		
		return u.get().getPosts();
		
		
	}
	
	@PostMapping(path="user/{id}/post")
	public ResponseEntity<Object> saveUserPost(@PathVariable Integer id, @RequestBody Post post ){
		Optional<UserModel> u = userRepository.findById(id);
		 if(!u.isPresent())
			 throw new UserNotFoundException("User not found for id "+id);
		 post.setUserModel(u.get());
		 Post p=postRepository.save(post);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(p.getId()).toUri(); 
		 
		 
		return ResponseEntity.created(location).build();
		
	}
	
	
}
