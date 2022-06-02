package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Usuario;
import com.spring.TecSUS.repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioControle {

    @Autowired
    private UsuarioRepositorio acao;

    @GetMapping("/usuarios/novo")
    public String index(Model model){
        List<Usuario>usuarios = (List<Usuario>)repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
    
    @GetMapping("/usuarios")
    public ModelAndView listarContratos(){
        ModelAndView mv = new ModelAndView("usuarios");
        List<Usuario> usuarios = acao.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }
    



}
