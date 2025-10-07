package com.springboot.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Student;

@Repository
@Transactional
public class StudentDao {
    Session session;

    @Autowired
    public void setSession(Session session) {
        this.session = session;
    }

    public void createStudent(Student s) {
        session.persist(s);
    }

    public List<Student> getStudents() {
        List<Student> data = null;
        data = session.createQuery("From Student", Student.class).list();
        return data;
    }

    public void updateStudent(Student s) {
        session.merge(s);
    }

    public void deleteStudent(int id) {
        Student obj = session.find(Student.class, id);
        session.remove(obj);
    }
}
