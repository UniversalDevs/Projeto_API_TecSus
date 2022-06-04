package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Administrador;
import com.spring.TecSUS.repositorio.AdministradoresRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdministradorControle {

    @Autowired
    private AdministradoresRepositorio repo;

    @GetMapping("/administradores")
    public String index(Model model){
        List<Administrador>administradores = (List<Administrador>)repo.findAll();
        model.addAttribute("administradores", administradores);
        return "/administradores";
    }

    @GetMapping("/administradores/novo")
    public String novoAdministrador(Model model) {
        return "administradorForm";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador){
        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);;
        return "redirect:/administradores";
    }
}
