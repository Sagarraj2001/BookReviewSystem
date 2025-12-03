package com.backend.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.Backend.DTO.ResponseStructure;
import com.backend.Backend.Entity.User;
import com.backend.Backend.Service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
    public ResponseEntity<ResponseStructure<User>> signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<User>> login(@RequestBody User req) {
        return userService.login(req.getEmail(), req.getPassword());
    }
	
	


}
