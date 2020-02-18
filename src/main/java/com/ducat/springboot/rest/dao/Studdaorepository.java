package com.ducat.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducat.springboot.rest.model.Student;

@Repository
public interface Studdaorepository extends JpaRepository<Student, Integer> {

}