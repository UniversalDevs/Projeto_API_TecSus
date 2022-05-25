package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Usuario;
import com.spring.TecSUS.repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioControle {

    @Autowired
    private UsuarioRepositorio repo;

    @GetMapping("/usuarios")
    public String index(Model model){
        List<Usuario>usuarios = (List<Usuario>)repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/usuarios";
    }

}
