package com.restservices.restwebservices.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restservices.restwebservices.Exceptions.UserNotFoundException;

@RestController
public class UserResource {
     
	@Autowired
	private UserServiceDao service;
	
	@GetMapping(value="/users")
	public List<User> retrieveAll(){
		return service.getAllUser();
		
	}
	@PostMapping(value="/users")
	public ResponseEntity addUser(@Valid @RequestBody User user) {
		User SavedUser= service.saveUser(user);
		System.out.println(SavedUser);
		
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(SavedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	@GetMapping("/users/{id}")
	public EntityModel<User> findUser(@PathVariable int id ) {
		User user= service.finById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id -"+id);
		}
		EntityModel<User> resource =new EntityModel(user);
		WebMvcLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAll());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id ) {
		User user= service.deleteUser(id);
		if(user==null) {
			throw new UserNotFoundException("id -"+id);
		}
		return user;
	}
}
