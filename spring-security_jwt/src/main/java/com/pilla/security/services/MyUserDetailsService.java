package com.pilla.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilla.security.entities.User;
import com.pilla.security.repos.USerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private USerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("No user found in DB with "+username);
		}
		return new UserPrincipal(user);
	}

}
