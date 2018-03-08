package com.nithyan.taskmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nithyan.taskmgmt.domain.User;
import com.nithyan.taskmgmt.service.IUserService;

@RestController
@RequestMapping("/")
public class UserController {

		@Autowired
		private IUserService iUserService;
		
		@GetMapping("fetchUserDetail")
		public User fetchUserDetail(@RequestParam(value="userId") String userId){
			User user = iUserService.fetchUserDetail(Integer.parseInt(userId));
			return user;
		}
		
		@GetMapping("fetchAllUsers")
		public List<User> fetchAllUsers(){
			List<User> allUserList = iUserService.fetchAllUsers();
			return allUserList;
		}
		
		@PostMapping("addUser")
		public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder){
			boolean flag = iUserService.addUser(user);
			if (flag == false) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/fetchUserDetail/{userId}")
					.buildAndExpand(user.getUserId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		@PutMapping("updateUser")
		public ResponseEntity<User> updateUser(@RequestBody User user){
			iUserService.updateUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		@DeleteMapping("deleteUser")
		public ResponseEntity<Void> deleteUser(@RequestParam(value="userId") String userId){
			iUserService.deleteUser(Integer.parseInt(userId));
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
}

