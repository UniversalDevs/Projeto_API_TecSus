package com.spring.TecSUS.controller;

import java.util.List;

import com.spring.TecSUS.model.Concessionaria;
import com.spring.TecSUS.service.ConcessionariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}
