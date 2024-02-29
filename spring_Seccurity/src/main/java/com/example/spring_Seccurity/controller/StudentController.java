package com.example.spring_Seccurity.controller;

import com.example.spring_Seccurity.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/welcome")
    public String visit(){
        return "welcome to student page!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello Student";
    }

    @PostMapping("/add/username/{username}/password/{password}")
    public String addStudent(@PathVariable("username") String username, @PathVariable("password") String password){
        studentService.addStudent(username, password);
        return  "student added successfully";
    }
}
