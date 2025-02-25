package com.pilla.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilla.security.entities.User;
import com.pilla.security.services.UserService;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class USerController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/users")
	@RolesAllowed("admin")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User addedUser = service.add(user);
		return new ResponseEntity<>(addedUser,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("users/{id}")
	@PreAuthorize("hasRole('user')")
	public Optional<User> getUser(@PathVariable long id) {
		
		return service.findById(id);
		
	}
	@PreAuthorize("hasRole('admin')")
	@GetMapping("users")
	public List<User> getAllUser() {
		return service.findAllUsers();
	}
	

}
