package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.exception.UserNotFoundException;
import com.model.User;

@Service
public class UserServiceImple implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public User getUserById(long id) {
		
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		
		User u = userRepo.findById(user.getUserId()).orElse(null);
		u.setPassword(user.getPassword());
		User updatedUser = userRepo.save(u);
		return updatedUser;
	}

	@Override
	public Map<String, Object> deleteUser(long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			User user = userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not Found with "+id));
			userRepo.delete(user);
			response.put("deleted",Boolean.TRUE);
		}
		
		catch(UserNotFoundException e)
		{
		    response.put("not deleted", e.getMessage());	
		}
		return response;
	}

}
