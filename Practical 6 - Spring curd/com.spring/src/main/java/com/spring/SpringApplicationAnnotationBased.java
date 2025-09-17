package com.spring;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.config.AppConfig;
import com.dao.StudentDao;
import com.pojo.Student;
import com.sun.tools.javac.launcher.Main;

public class SpringApplicationAnnotationBased {
	public static void main(String[] args) {
		
		// Ioc Container Creation
		ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Craete a object for student dao to preform curd operation on the student table
		StudentDao dao = container.getBean(StudentDao.class);
		
		// insert single record
		dao.insert("Ajay", 230510500, new Date(), "CSE");
		
		// insert 10 records
		for(int i = 0; i < 10; i++) {
			dao.insert("name " + i, (long)(230510501 + i), new Date(), "CSE");
		}
		
		// Retrieve and print records
		List<Student> data = dao.find();
		System.out.println();
		
		for(int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i).getId() + " | ");
			System.out.print(data.get(i).getName() + " | ");
			System.out.print(data.get(i).getEnrollment_no() + " | ");
			System.out.print(data.get(i).getDob() + " | ");
			System.out.print(data.get(i).getDepartment()+"\n");
		}
		System.out.println();
		
		// update 1st record/row
		Student s = data.getFirst();
		s.setDepartment("AIML");
		dao.update(s);
		
		// print the updated row details
		s = dao.find(s.getId());
		System.out.print("\nupdated details : \n" + s.getId() + " | ");
		System.out.print(s.getName() + " | ");
		System.out.print(s.getEnrollment_no() + " | ");
		System.out.print(s.getDob() + " | ");
		System.out.print(s.getDepartment()+"\n");
		
		
		// delete last row
		s = data.getLast();
		System.out.println("\nDeleted Record details : ");
		System.out.print(s.getId() + " | ");
		System.out.print(s.getName() + " | ");
		System.out.print(s.getEnrollment_no() + " | ");
		System.out.print(s.getDob() + " | ");
		System.out.print(s.getDepartment()+"\n");
		
		dao.remove(s); // called to delete the record
	}
}
