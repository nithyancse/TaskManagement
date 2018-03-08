package com.nithyan.taskmgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nithyan.taskmgmt.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByUserName(String userName);
    List<User> findByUserNameAndPassword(String userName, String password);
    
}
