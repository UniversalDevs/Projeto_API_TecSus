    package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.InstalacaoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InstalacaoControle {
    @Autowired
    InstalacaoRepositorio instalacaoService;

    @RequestMapping(value = "/instalacoes", method = RequestMethod.GET)
    public ModelAndView getInstalacoes(){
        ModelAndView mv = new ModelAndView("instalacoes");
        List<Instalacao> instalacoes = instalacaoService.findAll();
        mv.addObject("instalacoes", instalacoes);
        return mv;
    }

    @GetMapping("/instalacoes/{codigo_identificador}")
    public ModelAndView detalhesInstalacao(@PathVariable("codigo_identificador") long codigo_identificador) {
        ModelAndView mv =  new ModelAndView("detalhesInstalacao");
        Instalacao instalacao = instalacaoService.findById(codigo_identificador);
        mv.addObject("instalacao", instalacao);
        return mv;
    }

    @RequestMapping(value = "/instalacoes/novo", method = RequestMethod.GET)
    public String getInstalacaoForm(){
        return "instalacaoForm";
    }

    @RequestMapping(value = "/instalacoes/novo", method = RequestMethod.POST)
    public String saveInstalacao(@Validated Instalacao instalacao, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatorios");
            return "redirect:/instalacoes/novo";
        }
        instalacaoService.save(instalacao);
        return "redirect:/instalacoes";
    }

}
