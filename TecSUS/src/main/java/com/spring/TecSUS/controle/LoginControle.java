package com.spring.TecSUS.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.TecSUS.modelo.Administrador;
import com.spring.TecSUS.repositorio.AdministradoresRepositorio;

@Controller
public class LoginControle {
    @Autowired
    private AdministradoresRepositorio repo;

    @GetMapping("/login")
    public String index(){
        return "/login";
    }

    @PostMapping("/home")
    public String home(Model model, Administrador admParam){
        Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
        return "/home";
    }
}
