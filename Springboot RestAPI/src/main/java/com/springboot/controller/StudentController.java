package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.service.StudentDao;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @PostMapping
    public void createStudent(@RequestParam("name") String name, @RequestParam("age") int age) {
        dao.createStudent(new Student(name,age));
    }
    
    @GetMapping
    public List<Student> getStudents() {
        return dao.getStudents();
    }
    
    @PutMapping
    public void updateStudent(@RequestParam("id") int id, @RequestParam("name") String name,
            @RequestParam("age") int age) {
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        dao.updateStudent(s);
    }
    
    @DeleteMapping
    public void deleteStudent(@RequestParam("id")int id){
        dao.deleteStudent(id);
    }

}