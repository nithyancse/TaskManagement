package com.nithyan.taskmgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nithyan.taskmgmt.domain.UserRegistration;

public interface UserRegistrationRepository extends CrudRepository<UserRegistration, Integer> {

	List<UserRegistration> findByUserName(String userName);
    List<UserRegistration> findByUserNameAndEmailId(String UserName, String EmailId);
    
}
