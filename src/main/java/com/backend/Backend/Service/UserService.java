package com.backend.Backend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.Backend.DAO.UserDAO;
import com.backend.Backend.DTO.ResponseStructure;
import com.backend.Backend.Entity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;

	public ResponseEntity<ResponseStructure<User>> signup(User user) {

	    ResponseStructure<User> response = new ResponseStructure<>();

	    Optional<User> existingUser = userDao.getUserByEmail(user.getEmail());
	    if (existingUser.isPresent()) {
	        throw new RuntimeException("Email already exists!");
	    }

	    user.setPassword(user.getPassword());

	    User savedUser = userDao.saveUser(user);

	    response.setStatusCode(HttpStatus.CREATED.value());
	    response.setMessage("User Registered Successfully");
	    response.setData(savedUser);

	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<User>> login(String email, String password) {

		ResponseStructure<User> response = new ResponseStructure<>();

		Optional<User> optionalUser = userDao.getUserByEmail(email);
		if (optionalUser.isEmpty()) {
			throw new RuntimeException("User not found");
		}
		User user = optionalUser.get();
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid password");
		}
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Login Successful");
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
