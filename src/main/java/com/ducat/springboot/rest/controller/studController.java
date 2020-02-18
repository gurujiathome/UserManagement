package com.ducat.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ducat.springboot.rest.model.Student;
import com.ducat.springboot.rest.service.studservice;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class studController {

	@Autowired
	studservice dservice;

	@RequestMapping(value= "/Student/all", method= RequestMethod.GET)
	public List<Student> getStudents() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Students service is invoked.");
		return dservice.getStudents();
	}
	
	

	@RequestMapping(value= "/Student/{id}", method= RequestMethod.GET)
	public Student getStudentById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Student details by id is invoked.");

		Optional<Student> emp =  dservice.getStudentById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find Student with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/Student/add", method= RequestMethod.POST,headers="Accept=application/json")
	public Student createStudent(@RequestBody Student newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Student method is invoked.");
		return dservice.addNewStudent(newemp);
	}

	@RequestMapping(value= "/Student/update/{id}", method= RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student updemp, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Student details by id is invoked.");

		Optional<Student> emp =  dservice.getStudentById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find Student with id- " + id);

		/* IMPORTANT - To prevent the overiding of the existing value of the variables in the database, 
		 * if that variable is not coming in the @RequestBody annotation object. */
		
		
		// Required for the "where" clause in the sql query template.
		updemp.setId(id);
		return dservice.updateStudent(updemp);
	}

	@RequestMapping(value= "/Student/delete/{id}", method= RequestMethod.DELETE)
	public void deleteStudentById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Student by id is invoked.");

		Optional<Student> emp =  dservice.getStudentById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find Student with id- " + id);

		dservice.deleteStudentById(id);
	}

	@RequestMapping(value= "/Student/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Students is invoked.");
		dservice.deleteAllStudents();
	}
}