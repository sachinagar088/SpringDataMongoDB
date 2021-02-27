package com.sachin.demo.repository;

import com.sachin.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {
    List<Student> findByNameContains(String name);
}
