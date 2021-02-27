package com.sachin.demo.service;

import com.sachin.demo.model.Student;
import com.sachin.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student s){
        studentRepository.save(s);
    }
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public Optional<Student> getStudent(int id){
        Optional<Student> s1 = Optional.empty();
        try {
            s1 = studentRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return s1;
    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
    public List<Student> getAllStudentsByName(String name){
        return studentRepository.findByNameContains(name);
    }
    public Student updateSingleStudent(Student s, int id){
        Student s1= studentRepository.findById(id).orElse(null);
        if (s1 != null) {
            s1.setName(s.getName());
            s1.setMarks(s.getMarks());
            return studentRepository.save(s1);
        }
        return s;

    }
}
