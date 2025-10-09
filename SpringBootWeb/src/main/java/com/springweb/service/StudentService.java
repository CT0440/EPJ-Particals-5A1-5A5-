package com.springweb.service;

import com.springweb.model.Student;
import com.springweb.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public boolean create(Student s){
        try {
            dao.save(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Student> findAll(){
        return dao.findAll();
    }

    public Student get(Integer id){
        return dao.findById(id).orElse(null);
    }

    public Student update(Student s){
        return dao.save(s);
    }

    public boolean delete(Integer id){
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
