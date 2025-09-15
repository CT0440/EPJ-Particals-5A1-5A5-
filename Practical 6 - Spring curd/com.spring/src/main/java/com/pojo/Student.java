package com.pojo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	long enrollment_no;
	Date dob;
	String department;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, long enrollment_no, Date dob, String department) {
		super();
		this.name = name;
		this.enrollment_no = enrollment_no;
		this.dob = dob;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEnrollment_no() {
		return enrollment_no;
	}

	public void setEnrollment_no(long enrollment_no) {
		this.enrollment_no = enrollment_no;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
