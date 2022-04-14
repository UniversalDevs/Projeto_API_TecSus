package com.spring.TecSUS.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import com.spring.TecSUS.model.Instalacao;
import com.spring.TecSUS.service.InstalacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InstalacaoController {
    
    @Autowired
    InstalacaoService instalacaoService;

    @RequestMapping(value = "/instalacoes", method = RequestMethod.GET)
    public ModelAndView getInstalacoes(){
        ModelAndView mv = new ModelAndView("instalacoes");
        List<Instalacao> instalacoes = instalacaoService.findAll();
        mv.addObject("instalacoes", instalacoes);
        return mv;
    }

    @RequestMapping(value = "/instalacoes/{codigo_identificador}", method = RequestMethod.GET)
    public ModelAndView getInstalacaoDetails(@PathVariable("codigo_identificador") long codigo_identificador) {
        ModelAndView mv =  new ModelAndView("instalacaoDetails");
        Instalacao instalacao = instalacaoService.findById(codigo_identificador);
        mv.addObject("instalacao", instalacao);
        return mv;
    }

    @RequestMapping(value = "/instalacoes/novainstalacao", method = RequestMethod.GET)
    public String getInstalacaoForm(){
        return "instalacaoForm";
    }

    @RequestMapping(value = "/instalacoes/novainstalacao", method = RequestMethod.POST)
    public String saveInstalacao(@Valid Instalacao instalacao, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatorios");
            return "redirect:/instalacoes/novainstalacao";
        }
        instalacaoService.save(instalacao);
        return "redirect:/instalacoes";
    }
}
