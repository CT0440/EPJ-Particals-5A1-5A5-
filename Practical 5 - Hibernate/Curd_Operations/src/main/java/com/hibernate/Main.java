package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.EmployeeDao;
import com.pojo.Employee;

// if you want rerun the program again please remove/truncate the data from employee table
public class Main {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		
		 //insertion operation
		for(int i = 0; i < 100; i++) {
			dao.Insert(i+1, "name " + i, "CSE");
		}
		
		
		// reterive operation ( all data )
		List<Employee> data = dao.find();
		
		if(data != null) {
			for(int i = 0; i < data.size(); i++) {
				System.out.println("id : " + data.get(i).getId());
				System.out.println("name : " + data.get(i).getName());
				System.out.println("department : " + data.get(i).getDepartment());
				System.out.println();
			}
		}
		
		// update data of id 1
		if(data != null) {
			Employee e = data.get(1);
			//print data before update
			System.out.println("\n Before update : " + e.toString() + "\n");
			e.setName("Ajay");
			dao.update(e);
			
			
			// get data after update
			e = dao.find(e.getId());
			// print data after update
			System.out.println("\n After update : " + e.toString() + "\n");
		}
		
		
		// delete operation
		if(data != null) {
			Employee e = data.get(1);
			dao.remove(e.getId());
		}
	}
}
