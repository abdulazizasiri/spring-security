package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeResource {

    @RequestMapping({"/home"})
    public String homePage(){
        
    }
}
