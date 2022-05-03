package com.spring.TecSUS.controller;

import java.util.List;

import javax.validation.Valid;

import com.spring.TecSUS.model.Cliente;
import com.spring.TecSUS.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.engine.AttributeName;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    //Lista todos os clientes
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ModelAndView getClientes() {
        ModelAndView mv = new ModelAndView("clientes");
        List<Cliente> clientes = clienteService.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    //Lista os dados do cliente
    @RequestMapping(value = "/clientes/{cli_id}", method = RequestMethod.GET)
    public ModelAndView getClienteDetails(@PathVariable("cli_id") long cli_id) {
        ModelAndView mv = new ModelAndView("clienteDetails");
        Cliente cliente = clienteService.findById(cli_id);
        mv.addObject("cliente", cliente);
        return mv;
    }

    @RequestMapping(value = "/clientes/novocliente", method = RequestMethod.GET)
    public String getClienteForm(){
        return "clienteForm";
    }

    //Salva um cliente
    @RequestMapping(value = "/clientes/novocliente", method = RequestMethod.POST)
    public String saveCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
            return "redirect:/clientes/novocliente";
        }
        clienteService.save(cliente);
        return "redirect:/clientes";
    }
}
