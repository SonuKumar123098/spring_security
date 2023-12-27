package com.example.spring_Seccurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
     @GetMapping("/welcome")
    public String visit(){
         return "welcome to public page!";
     }
}
