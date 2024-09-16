package com.UserManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.Model.User;
import com.UserManagement.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	// For saving new user 
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		if(ObjectUtils.isEmpty(saveUser)) {
			return new ResponseEntity<>("User not Saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}
	
	
	// For getting all user 
	@GetMapping("/getAllUser")
	public ResponseEntity<?>getAllUser(){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.OK);
		
	}
	// For Update Response Entity
	@PutMapping("/d")
	public ResponseEntity<?>updateUser(@RequestBody User user){
		User updateUser = userService.updateUser(user);
		if(ObjectUtils.isEmpty(updateUser)) {
			return new ResponseEntity<>("User not updated", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(updateUser,HttpStatus.CREATED);
	}
	
	// For deleting from database
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteUser(@PathVariable Integer id){
		
		userService.deleteUser(id);
		
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id){
		User userById = userService.getUserById(id);
		if(ObjectUtils.isEmpty(userById)) {
			return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(userById,HttpStatus.OK);
		
	}
}
