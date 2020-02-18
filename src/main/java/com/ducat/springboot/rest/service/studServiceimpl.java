package com.ducat.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.springboot.rest.dao.Studdaorepository;
import com.ducat.springboot.rest.model.Student;

@Service
public class studServiceimpl implements studservice {

	@Autowired
	Studdaorepository dao1;

	@Override
	public List<Student> getStudents() {
		return dao1.findAll();
	}
	@Override
	public Optional<Student> getStudentById(int empid) {
		return dao1.findById(empid);
	}
	@Override
	public Student addNewStudent(Student emp) {
		return dao1.save(emp);
	}
	@Override
	public Student updateStudent(Student emp) {
		return dao1.save(emp);
	}
	@Override
	public void deleteStudentById(int empid) {
		dao1.deleteById(empid);
	}
	@Override
	public void deleteAllStudents() {
		dao1.deleteAll();
	}
}