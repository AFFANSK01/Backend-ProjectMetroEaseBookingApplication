package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.UserNotFoundException;
import com.model.User;
import com.service.UserService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;
	
	/*
	@PostMapping("/addUser")
	public User addUser(@RequestBody User u) {
		return userService.saveUser(u);
	}
	*/
	
	
	@GetMapping("/getUserById/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		User u = userService.updateUser(user);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("User", "User updated").body(u);
	}
	
	/*
	 
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable ("id") long id) throws UserNotFoundException
	{
		Map<String, Object> response = userService.deleteUser(id);
		
		return ResponseEntity.ok(response);
	}
	
	*/

	
}
