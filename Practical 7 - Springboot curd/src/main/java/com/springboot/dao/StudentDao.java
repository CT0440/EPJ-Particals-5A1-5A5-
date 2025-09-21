package com.springboot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.pojo.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;  // injected by Spring

    // Retrieve entire data
    @Transactional(readOnly = true)
    public List<Student> find() {
        List<Student> data = entityManager.createQuery("FROM Student", Student.class).getResultList();
        System.out.println("data fetched successfully");
        return data;
    }

    // Retrieve data by id
    @Transactional(readOnly = true)
    public Student find(Integer id) {
        Student s = entityManager.find(Student.class, id);
        System.out.println("data fetched successfully");
        return s;
    }

    // Insert new student
    @Transactional
    public void insert(String name, long enroll_no, Date date, String dept) {
        Student record = new Student(name, enroll_no, date, dept);
        entityManager.persist(record);
        System.out.println("data inserted successfully");
    }

    // Update existing student
    @Transactional
    public void update(Student s) {
        entityManager.merge(s);
        System.out.println("data updated successfully");
    }

    // Remove student
    @Transactional
    public void remove(Student s) {
        entityManager.remove(entityManager.contains(s) ? s : entityManager.merge(s));
        System.out.println("data removed successfully");
    }
}
