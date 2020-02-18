package com.ducat.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import com.ducat.springboot.rest.model.Student;

public interface studservice {

	public List<Student> getStudents();
	public Optional<Student> getStudentById(int empid);
	public Student addNewStudent(Student emp);
	public Student updateStudent(Student emp);
	public void deleteStudentById(int empid);
	public void deleteAllStudents();
	

}