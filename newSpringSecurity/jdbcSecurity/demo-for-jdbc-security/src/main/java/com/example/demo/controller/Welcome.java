package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String home(){
        return ("<h1> Weclome </h1>");
    }


    @GetMapping("/user")
    public String user(){
        return ("<h1> Hello Users </h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Weclome Admin</h1>");
    }
}
