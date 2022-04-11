package com.spring.TecSUS.controller;

import java.util.List;

import com.spring.TecSUS.model.Cliente;
import com.spring.TecSUS.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ModelAndView getClientes() {
        ModelAndView mv = new ModelAndView("clientes");
        List<Cliente> clientes = clienteService.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    @RequestMapping(value = "/clientes/{cli_id}", method = RequestMethod.GET)
    public ModelAndView getClienteDetails(@PathVariable("cli_id") long cli_id) {
        ModelAndView mv = new ModelAndView("clienteDetails");
        Cliente cliente = clienteService.findById(cli_id);
        mv.addObject("cliente", cliente);
        return mv;
    }

    
}
