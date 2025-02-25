package com.pilla.security.services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pilla.security.entities.User;

@Service
public class UserPrincipal implements UserDetails {
	
	
	private User user;
	
	public UserPrincipal(User user) {
		this.user =user;
	}
		
		

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		System.out.println(user.getRole());
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

}
