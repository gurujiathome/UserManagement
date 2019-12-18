package com.ducat.springboot.rest.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component

// Spring jpa jars.
@Entity
@Table(name= "userdata")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int uid;
	private String uname;
	private String uphone;
	private String status;
	//@DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
	@JsonFormat(pattern = "YYYY-MM-dd")
	private String created_date;
	@JsonFormat(pattern = "YYYY-MM-dd")
	private String modified_date;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date() {
		LocalDate ld = LocalDate.now();
		String datex = ld.toString();
	    this.created_date = datex;
		//this.created_date = created_date;
	}
	public void setCreated_date(String localDate) {
		
	    this.created_date = localDate;
	}
	
	public String getModified_date() {
		
		return modified_date;
	}
	public void setModified_date(String modified_date2) {
		LocalDate localD1 = LocalDate.now(); 
		String ld = localD1.toString();
		this.modified_date = ld;
		//this.modified_date = modified_date;
	}



//	private String created_date;
//	private String modified_date;
  
	}