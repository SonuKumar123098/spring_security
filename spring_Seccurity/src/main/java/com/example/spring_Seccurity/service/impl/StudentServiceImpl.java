package com.example.spring_Seccurity.service.impl;

import com.example.spring_Seccurity.model.Student;
import com.example.spring_Seccurity.repository.StudentRepository;
import com.example.spring_Seccurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(String username, String password) {
        Student student=new Student();
        student.setUsername(username);
        student.setPassword(passwordEncoder.encode(password));
        student.setRole("ROLE_STUDENT,ROLE_RANDOM");
        Student savedStudent=studentRepository.save(student);
        return savedStudent;
    }
}
