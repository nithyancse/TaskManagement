package com.nithyan.taskmgmt.service;

import java.util.List;

import com.nithyan.taskmgmt.domain.UserRegistration;

public interface IUserRegistrationService {

	public UserRegistration fetchUserDetail(int userId);

	public List<UserRegistration> fetchAllUsers();

	public boolean addUser(UserRegistration userRegistration);

	public void updateUser(UserRegistration userRegistration);

	public void deleteUser(int userId);

}
