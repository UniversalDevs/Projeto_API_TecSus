package com.spring.TecSUS.controle;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.TecSUS.modelo.Administrador;
import com.spring.TecSUS.repositorio.AdministradoresRepositorio;
import com.spring.TecSUS.servico.servicoCookie;

@Controller
public class LoginControle {
  @Autowired
  private AdministradoresRepositorio repo;

  @GetMapping("/login")
  public String index(){
    return "login";
  }

  @PostMapping("/logar")
  public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
    Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
    if(adm != null){
      int tempoLogado = (60*60); // 1 hora de cookie
      if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
      servicoCookie.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
      servicoCookie.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
      model.addAttribute("administrador", adm);
      return "redirect:/home";
    }
    model.addAttribute("erro", "Usuário ou senha inválidos");
    return "login";
  }

  @GetMapping("/home")
    public String viewHomePage(Model model){
        return "home";
    }
  
  @GetMapping("/sair")
  public String logar(HttpServletResponse response) throws IOException{
    servicoCookie.setCookie(response, "usuarioId", "", 0);
    return "redirect:/login";
  }
}