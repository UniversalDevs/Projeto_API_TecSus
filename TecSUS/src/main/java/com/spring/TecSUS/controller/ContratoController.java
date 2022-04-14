package com.spring.TecSUS.controller;

import java.lang.reflect.Method;
import java.util.List;

import javax.validation.Valid;

import com.spring.TecSUS.model.Contrato;
import com.spring.TecSUS.service.ContratoService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContratoController {
    
    @Autowired
    ContratoService contratoService;

    @RequestMapping(value = "/contratos", method = RequestMethod.GET)
    public ModelAndView getContratos(){
        ModelAndView mv =  new ModelAndView("contratos");
        List<Contrato> contratos = contratoService.findAll();
        mv.addObject("contratos", contratos);
        return mv;
    }

    @RequestMapping(value = "/contratos/{contrato_id}", method = RequestMethod.GET)
    public ModelAndView getContratoDetails(@PathVariable("contrato_id") long contrato_id) {
        ModelAndView mv = new ModelAndView("contratoDetails");
        Contrato contrato = contratoService.findById(contrato_id);
        mv.addObject("contrato", contrato);
        return mv;
    }

    @RequestMapping(value = "/contratos/novocontrato", method = RequestMethod.GET)
    public String getContratoForm(){
        return "contratoForm";
    }

    @RequestMapping(value = "/contratos/novocontrato", method = RequestMethod.POST)
    public String saveContrato(@Valid Contrato contrato, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem","Verifique os campos obrigatórios");
            return "redirect:/contratos/novocontrato";
        }
        contratoService.save(contrato);
        return "redirect:/contratos";

    }
}