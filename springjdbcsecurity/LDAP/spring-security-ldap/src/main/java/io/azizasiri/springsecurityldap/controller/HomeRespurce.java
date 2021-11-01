package io.azizasiri.springsecurityldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRespurce {
    @GetMapping("/")
    public String getMain(){
        return ("<h1> Hello LDAPY</h1>");
    }

}
