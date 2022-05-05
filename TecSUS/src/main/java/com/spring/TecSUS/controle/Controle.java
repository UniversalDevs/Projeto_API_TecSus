package com.spring.TecSUS.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controle {

    @GetMapping("")
    public String viewHomePage(){
        return "home";
    }
}

