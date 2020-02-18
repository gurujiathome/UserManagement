package com.ducat.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ducat.springboot.rest.model.User;
import com.ducat.springboot.rest.model.UserModel;
import com.ducat.springboot.rest.service.Myservice;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Mycontroller {

	@Autowired
	Myservice service;

	@RequestMapping(value= "/User/all", method= RequestMethod.GET)
	public List<User> getUsers() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Users service is invoked.");
		return service.getUsers();
	}
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public UserModel validateLogin() {
		return new UserModel("User successfully authenticated");
	}

	@RequestMapping(value= "/User/{id}", method= RequestMethod.GET)
	public User getUserById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get User details by id is invoked.");

		Optional<User> emp =  service.getUserById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find User with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/User/add", method= RequestMethod.POST,headers="Accept=application/json")
	public User createUser(@RequestBody User newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new User method is invoked.");
		return service.addNewUser(newemp);
	}

	@RequestMapping(value= "/User/update/{id}", method= RequestMethod.PUT)
	public User updateUser(@RequestBody User updemp, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update User details by id is invoked.");

		Optional<User> emp =  service.getUserById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find User with id- " + id);

		/* IMPORTANT - To prevent the overiding of the existing value of the variables in the database, 
		 * if that variable is not coming in the @RequestBody annotation object. */
		
		if(updemp.getUname() == null || updemp.getUname().isEmpty())
			updemp.setUname(emp.get().getUname());
		if(updemp.getUphone() == null || updemp.getUphone().isEmpty())
			updemp.setUphone(emp.get().getUphone());
		if(updemp.getStatus() == null)
			updemp.setStatus(emp.get().getStatus());
		
	if( !(updemp.getCreated_date().isEmpty()) ) {
			updemp.setCreated_date(emp.get().getCreated_date());
			}
		// Required for the "where" clause in the sql query template.
		updemp.setUid(id);
		return service.updateUser(updemp);
	}

	@RequestMapping(value= "/User/delete/{id}", method= RequestMethod.DELETE)
	public void deleteUserById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete User by id is invoked.");

		Optional<User> emp =  service.getUserById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find User with id- " + id);

		service.deleteUserById(id);
	}

	@RequestMapping(value= "/User/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Users is invoked.");
		service.deleteAllUsers();
	}
}