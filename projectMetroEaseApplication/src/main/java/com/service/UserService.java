package com.service;

import java.util.List;
import java.util.Map;

import com.model.User;

public interface UserService{
	
   public User saveUser(User user);
   
   public User getUserById(long id);
   
   public List<User> getAllUser();
   
   public User updateUser(User user);
   
   public Map<String, Object> deleteUser(long id);
   
   
}
