package com.ducat.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.springboot.rest.dao.Mydaorepository;
import com.ducat.springboot.rest.model.User;

@Service
public class Myserviceimpl implements Myservice {

	@Autowired
	Mydaorepository dao;

	@Override
	public List<User> getUsers() {
		return dao.findAll();
	}
	@Override
	public Optional<User> getUserById(int empid) {
		return dao.findById(empid);
	}
	@Override
	public User addNewUser(User emp) {
		return dao.save(emp);
	}
	@Override
	public User updateUser(User emp) {
		return dao.save(emp);
	}
	@Override
	public void deleteUserById(int empid) {
		dao.deleteById(empid);
	}
	@Override
	public void deleteAllUsers() {
		dao.deleteAll();
	}
}