package com.UserManagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UserManagement.Model.User;

@Service
public interface UserService {
	
	public User saveUser(User user);// For saving all user in you db
	
	public List<User> getAllUser();// For get all user 
	
	public User updateUser(User user);// to update userupdate 
	
	public void deleteUser(Integer userId);// to delete deleteUser abstract method implemented in interface

	public User getUserById(Integer userId);
}
