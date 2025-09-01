package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Employee;

public class Main {
	public static void main(String[] args) {
	  SessionFactory factory = new Configuration().configure().buildSessionFactory();
	  
	  Session session = factory.openSession();
	  
	  try {
	    Transaction tx = session.beginTransaction();
		Employee record = new Employee(2,"Arjun","CSE");
		
		session.persist(record);
		tx.commit();
		System.out.println("data inserted successfully");
		session.close();
	    
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
}




