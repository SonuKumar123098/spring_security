package com.example.spring_Seccurity.repository;

import com.example.spring_Seccurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByUsername(String username);
}
