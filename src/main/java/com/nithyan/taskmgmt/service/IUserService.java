package com.nithyan.taskmgmt.service;

import java.util.List;

import com.nithyan.taskmgmt.domain.User;

public interface IUserService {

	public User fetchUserDetail(int userId);

	public List<User> fetchAllUsers();

	public boolean addUser(User userRegistration);

	public void updateUser(User userRegistration);

	public void deleteUser(int userId);

}
