package com.springweb.repository;

import com.springweb.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentDao extends JpaRepository<Student, Integer>{}
