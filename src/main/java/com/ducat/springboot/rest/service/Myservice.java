package com.ducat.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import com.ducat.springboot.rest.model.User;

public interface Myservice {

	public List<User> getUsers();
	public Optional<User> getUserById(int empid);
	public User addNewUser(User emp);
	public User updateUser(User emp);
	public void deleteUserById(int empid);
	public void deleteAllUsers();
	

}