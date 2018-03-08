package com.nithyan.taskmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nithyan.taskmgmt.domain.User;
import com.nithyan.taskmgmt.service.ILoginService;

@RestController
@RequestMapping("/")
public class LoginController {

		@Autowired
		private ILoginService iLoginService;
		
		@PostMapping("login")
		public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder){
			int userId = iLoginService.validateUser(user);
			if (userId == 0) {
				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/fetchUserDetail/userId="+userId)
					.buildAndExpand(user.getUserId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
		
		
}

