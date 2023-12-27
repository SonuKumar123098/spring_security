package com.example.spring_Seccurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String visit(){
        return "welcome to student page!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello Student";
    }
}
