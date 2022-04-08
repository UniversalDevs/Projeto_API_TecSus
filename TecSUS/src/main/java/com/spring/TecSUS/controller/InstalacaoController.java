package com.spring.TecSUS.controller;

import java.util.List;

import com.spring.TecSUS.model.Instalacao;
import com.spring.TecSUS.service.InstalacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InstalacaoController {
    
    @Autowired
    InstalacaoService instalacaoService;

    public ModelAndView getInstalacoes(){
        ModelAndView mv = new ModelAndView("instalacoes");
        List<Instalacao> instalacoes = instalacaoService.findAll();
        mv.addObject("instalacoes", instalacoes);
        return mv;
    }
}
