package com.nithyan.taskmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nithyan.taskmgmt.domain.UserRegistration;
import com.nithyan.taskmgmt.service.IUserRegistrationService;

@RestController
@RequestMapping("/")
public class UserRegistrationController { 

	@Autowired
	private IUserRegistrationService iUserRegistrationService;
	
	@GetMapping("fetchUserDetail/{userId}")
	public UserRegistration fetchUserDetail(@PathVariable("userId") int userId){
		UserRegistration userRegistration = iUserRegistrationService.fetchUserDetail(userId);
		return userRegistration;
	}
	
	@GetMapping("fetchAllUsers")
	public List<UserRegistration> fetchAllUsers(){
		List<UserRegistration> allUserList = iUserRegistrationService.fetchAllUsers();
		return allUserList;
	}
	
	@PostMapping("addUser")
	public ResponseEntity<Void> addUser(@RequestBody UserRegistration userRegistration, UriComponentsBuilder builder){
		boolean flag = iUserRegistrationService.addUser(userRegistration);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/fetchUserDetail/{userId}")
				.buildAndExpand(userRegistration.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("updateUser")
	public ResponseEntity<UserRegistration> updateUser(@RequestBody UserRegistration userRegistration){
		iUserRegistrationService.updateUser(userRegistration);
		return new ResponseEntity<UserRegistration>(userRegistration, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteUser/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId){
		iUserRegistrationService.deleteUser(userId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
