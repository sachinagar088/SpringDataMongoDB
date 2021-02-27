package com.sachin.demo.controllers;

import com.sachin.demo.model.Student;
import com.sachin.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController{
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentService.getAll();
    }
    @GetMapping("/student/{id}")
    public Optional<Student> getSingleStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }
    @GetMapping("/student/names/{name}")
    public List<Student> getStudentsWithNames(@PathVariable("name") String name){
        return studentService.getAllStudentsByName(name);
    }
    @PostMapping("/student")
    public void add(@RequestBody Student s){
        studentService.addStudent(s);
    }
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student s , @PathVariable("id") int id){
        return studentService.updateSingleStudent(s,id);
    }


}