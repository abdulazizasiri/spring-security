package com.spring_security.SpringSecurity.controller;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{

    @GetMapping("/")
    public String hello(){
        UserDetailsService
        return ("<h1> Welcome </h1>");
    }

    @GetMapping("/admin")
    public String admineHome(){
        return "LoginPage";
    }


    @GetMapping("/user")
    public String userHome(){
        return ("<h1> Normal User People</h1>");
    }

}
