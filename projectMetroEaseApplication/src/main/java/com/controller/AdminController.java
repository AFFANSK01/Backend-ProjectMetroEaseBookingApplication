package com.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exception.UserNotFoundException;
import com.model.Admin;
import com.model.User;
import com.service.AdminService;

import com.service.UserService;

@RestController

@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;
	
	
	  @PostMapping("/addUser") 
	  public User addUser(@RequestBody User u) {
	  return userService.saveUser(u); }
	  
	 
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable ("id") long id) throws UserNotFoundException
	{
		Map<String, Object> response = userService.deleteUser(id);
		
		return ResponseEntity.ok(response);
	}

	//add the useradd in this controller
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin a){
		Admin admin = adminService.saveAdmin(a);
		return ResponseEntity.status(HttpStatus.CREATED).header("admin", "admin added").body(admin);
		
	}
	
	//getOneAdmin method is not required because admin is only one
	
	@GetMapping("/getAdmin/{id}")
	public Admin getAdmin(@PathVariable ("id") long adminId){
		return adminService.getAdmin(adminId);		
	}
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> updateAdmin(Admin admin) {
		Admin a = adminService.updateAdmin(admin);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("admin", "admin updated").body(a);
	
	}
	

	/*
	@Autowired
	MetroService metroService;
	
	@PostMapping("/addMetro")
	public ResponseEntity<Metro> addMetro(@RequestBody Metro metro) {
		
		Metro m = metroService.saveMetro(metro);
		return ResponseEntity.status(HttpStatus.CREATED).header("Metro", "Metro added").body(m);
	}
	
	@GetMapping("/getOneMetro/{id}")
	public ResponseEntity<Metro> getOneMetro(@PathVariable ("id") long id) throws MetroNotFoundException{
			
		Metro metro = metroService.getOneMetro(id);
		
		return ResponseEntity.status(HttpStatus.OK).header("metro", "metro found").body(metro);
		
	}
	
	@GetMapping("/getAllMetro")
	public List<Metro> getAllMetro(){
		
		return metroService.getAllMetro();
		
	}
	
	@PutMapping("/updateMetro/{id}")
	public ResponseEntity<Metro> updateMetro(@RequestBody Metro metro)
	{
		Metro m = metroService.updateMetro(metro);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Metro", "Metro updated").body(m);
	}
	
	@DeleteMapping("/deleteMetro/{id}")
	public ResponseEntity<Map<String, Object>> deleteMetro(@PathVariable ("id") long id) throws MetroNotFoundException
	{
		Map<String, Object> response = metroService.deleteMetro(id);
		
		return ResponseEntity.ok(response);
	}
    */
	
}
