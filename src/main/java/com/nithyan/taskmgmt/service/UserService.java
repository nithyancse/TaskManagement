package com.nithyan.taskmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithyan.taskmgmt.domain.User;
import com.nithyan.taskmgmt.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;

	public User fetchUserDetail(int userId){
		User obj = userRepository.findById(userId).get();
		return obj;
		
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(e -> userList.add(e));
		return userList;
	}

	@Override
	public boolean addUser(User user) {
		List<User> list = userRepository.findByUserName(user.getUserName()); 	
        if (list.size() > 0) {
        	return false;
        } else {
        	userRepository.save(user);
        }
        return true;
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	
}
