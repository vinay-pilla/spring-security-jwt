package com.pilla.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilla.security.entities.User;
@Repository
public interface USerRepo extends JpaRepository<User, Long> {

	
	
}
