package com.springboot;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.dao.StudentDao;
import com.springboot.pojo.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(Application.class, args);

		StudentDao dao = container.getBean(StudentDao.class);

		// insert single record
		dao.insert("Ajay", 230510500, new Date(), "CSE");

		// insert 10 records
		for (int i = 0; i < 10; i++) {
			dao.insert("name " + i, (long) (230510500 + i), new Date(), "CSE");
		}

		// Retrieve and print record
		List<Student> data = dao.find();
		System.out.println();

		for (int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i).getId() + " | ");
			System.out.print(data.get(i).getName() + " | ");
			System.out.print(data.get(i).getEnrollment_no() + " | ");
			System.out.print(data.get(i).getDob() + " | ");
			System.out.print(data.get(i).getDepartment() + "\n");
		}
		System.out.println();

		// update 1st record
		if (!data.isEmpty()) {
			Student s = data.getFirst(); // Java 21 method
			s.setDepartment("AIML");
			dao.update(s);

			// print the updated row}
			s = dao.find(s.getId());
			System.out.print("\nupdated details : \n" + s.getId() + " | ");
			System.out.print(s.getName() + " | ");
			System.out.print(s.getEnrollment_no() + " | ");
			System.out.print(s.getDob() + " | ");
			System.out.print(s.getDepartment() + "\n");
		} else {
			System.out.println("No students found in DB.");
		}

		// delete last row
		if (!data.isEmpty()) {
			Student s = data.getLast();
			System.out.println("\nDeleted Record details : ");
			System.out.print(s.getId() + " | ");
			System.out.print(s.getName() + " | ");
			System.out.print(s.getEnrollment_no() + " | ");
			System.out.print(s.getDob() + " | ");
			System.out.print(s.getDepartment() + "\n");

			dao.remove(s);
		}

	}

}
