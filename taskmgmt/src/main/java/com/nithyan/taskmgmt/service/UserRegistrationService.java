package com.nithyan.taskmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithyan.taskmgmt.domain.UserRegistration;
import com.nithyan.taskmgmt.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService implements IUserRegistrationService {
	
	@Autowired
	UserRegistrationRepository userRegistrationRepository;

	public UserRegistration fetchUserDetail(int userId){
		UserRegistration obj = userRegistrationRepository.findById(userId).get();
		return obj;
		
	}

	@Override
	public List<UserRegistration> fetchAllUsers() {
		List<UserRegistration> userList = new ArrayList<>();
		userRegistrationRepository.findAll().forEach(e -> userList.add(e));
		return userList;
	}

	@Override
	public boolean addUser(UserRegistration userRegistration) {
		List<UserRegistration> list = userRegistrationRepository.findByUserName(userRegistration.getUserName()); 	
        if (list.size() > 0) {
        	return false;
        } else {
        	userRegistrationRepository.save(userRegistration);
        }
        return true;
	}

	@Override
	public void updateUser(UserRegistration userRegistration) {
		userRegistrationRepository.save(userRegistration);
	}

	@Override
	public void deleteUser(int userId) {
		userRegistrationRepository.deleteById(userId);
	}
	
}
