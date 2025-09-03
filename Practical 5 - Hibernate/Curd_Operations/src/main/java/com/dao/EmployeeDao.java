package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.Factory;
import com.pojo.Employee;

public class EmployeeDao {
	SessionFactory factory = null;

	public EmployeeDao() {
		super();
		this.factory = Factory.getFactory();
	}

	// insertion operation
	public void Insert(int id, String name, String department) {
		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			Employee record = new Employee(id, name, department);
			session.persist(record);

			tx.commit();
			System.out.println("data inserted successfully");
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Retrieval operation ( all data )
	public List<Employee> find() {
		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			List<Employee> data = session.createQuery("from Employee", Employee.class).list();
			tx.commit();
			session.close();
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	// Retrieval operation ( get by id )
	public Employee find(int id) {
		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			Employee data = session.get(Employee.class, id);
			tx.commit();
			session.close();
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	// update operation
	public void update(Employee e) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.merge(e); // Correctly update the entity
			tx.commit();
			System.out.println("Record updated successfully");
		} catch (Exception e2) {
			if (tx != null) {
				tx.rollback(); // Rollback in case of an error
			}
			e2.printStackTrace();
		} finally {
			session.close(); // Ensure session is closed
		}
	}

	// deletion operation
	public void remove(int id) {
		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			Employee e = session.get(Employee.class, id);

			if (e == null) {
				System.out.println("Record not found");
				return;
			}

			session.remove(e);
			tx.commit();
			System.out.println("record deleted successfully");
			session.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

}
