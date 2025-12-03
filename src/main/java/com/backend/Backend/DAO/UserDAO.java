package com.backend.Backend.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.Backend.Entity.User;
import com.backend.Backend.Repository.UserRepository;

@Repository
public class UserDAO {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public Optional<User> getUserByEmail(String email){
		return userRepo.findByEmail(email);
	}
}
