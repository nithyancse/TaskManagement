package com.nithyan.taskmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithyan.taskmgmt.domain.User;
import com.nithyan.taskmgmt.repository.UserRepository;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	UserRepository userRepository;
	
	public int validateUser(User user){
		List<User> list = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()); 	
        if (list.size() > 0) {
        	return list.get(0).getUserId();
        } 
        return 0;
	}

}
