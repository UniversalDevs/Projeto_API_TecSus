package com.spring.TecSUS.controller;

import java.util.List;

import javax.validation.Valid;

import com.spring.TecSUS.model.Concessionaria;
import com.spring.TecSUS.service.ConcessionariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConcessionariaController {
    
    @Autowired
    ConcessionariaService concessionariaService;

    @RequestMapping(value = "/concessionarias", method = RequestMethod.GET)
    public ModelAndView getConcessionarias(){
        ModelAndView mv = new ModelAndView("concessionarias");
        List<Concessionaria> concessionarias = concessionariaService.findAll();
        mv.addObject("concessionarias", concessionarias);
        return mv;
        
    
    }

    @RequestMapping(value = "/concessionarias/{concessionaria_id}", method = RequestMethod.GET)
    public ModelAndView getConcessionariaDetails(@PathVariable("concessionaria_id") long concessionaria_id) {
        ModelAndView mv =  new ModelAndView("concessionariaDetails");
        Concessionaria concessionaria = concessionariaService.findById(concessionaria_id);
        mv.addObject("concessionaria", concessionaria);
        return mv;
    }

    @RequestMapping(value = "/concessionarias/novaconcessionaria", method = RequestMethod.GET)
    public String getConcessionariaForm(){
        return "concessionariaForm";
    }

    @RequestMapping(value = "/concessionarias/novaconcessionaria", method = RequestMethod.POST)
    public String saveConcessionaria(@Valid Concessionaria concessionaria, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatorios");
            return "redirect:/concessionarias/novaconcessionaria";
        }
        concessionariaService.save(concessionaria);
        return "redirect:/concessionarias";
    }
}

