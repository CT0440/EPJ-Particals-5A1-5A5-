package com.springweb.controller;

import com.springweb.model.Student;
import com.springweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/")
public class StudentController {
    StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(ModelAndView m) {
        m.addObject("data", service.findAll());
        m.setViewName("index");
        return m;
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Student s = new Student(name, age);
        service.create(s);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(Student s) {
        service.update(s);
        return "redirect:/";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";  // resolves to /WEB-INF/views/error.jsp
    }

}
