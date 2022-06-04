package com.spring.TecSUS.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.TecSUS.modelo.Administrador;
import com.spring.TecSUS.repositorio.AdministradoresRepositorio;

@Controller
public class Controle {

    @Autowired
    private AdministradoresRepositorio administradoresRepositorio;

    @Autowired
    private LoginControle loginControle;

    
}

