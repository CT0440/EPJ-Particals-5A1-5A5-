package com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Student;

@Repository
public class StudentDao {
	
	private SessionFactory factory;
	
	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// Retrieve entire data
	@Transactional
	public List<Student> find() {
		Session session = factory.getCurrentSession();
		List<Student> data = session.createQuery("From Student",Student.class).list();
		System.out.println("data fetched successfully");
		return data;
	}
	
	// Retrieve data by id
		@Transactional
		public Student find(Integer id) {
			Session session = factory.getCurrentSession();
			Student s = session.get(Student.class, id);
			System.out.println("data fetched successfully");
			return s;
		}
	
	@Transactional
	public void insert(String name, long enroll_no, Date date, String dept) {
		Session session = factory.getCurrentSession();
		Student record = new Student(name,enroll_no, date, dept);
		session.persist(record);
		System.out.println("data inserted successfully");
	}
	
	@Transactional
	public void update(Student s) {
		Session session = factory.getCurrentSession();
		session.merge(s);
		System.out.println("data updated successfully");
	}
	
	@Transactional
	public void remove(Student s) {
		Session session = factory.getCurrentSession();
		session.remove(s);
		System.out.println("data removed successfully");
	}
}
