package com.pilla.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilla.security.entities.User;
import com.pilla.security.repos.USerRepo;

@Service
public class UserService {
	
	@Autowired
	USerRepo repo;

	public User add(User user) {
		return repo.save(user);
		
	}

	public Optional<User> findById(long id) {
		
		return repo.findById(id);
		
	}

	public List<User> findAllUsers() {
		
		return repo.findAll()	;
	}
	

}
