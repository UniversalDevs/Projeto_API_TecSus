package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Energia;
import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.ClienteRepositorio;
import com.spring.TecSUS.repositorio.ConcessionariaRepositorio;
import com.spring.TecSUS.repositorio.ContratoRepositorio;
import com.spring.TecSUS.repositorio.EnergiaRepositorio;
import com.spring.TecSUS.repositorio.InstalacaoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EnergiaControle {
    
    @Autowired
    private EnergiaRepositorio acao;
    @Autowired
    private ClienteRepositorio acaoCliente;
    @Autowired
    private ConcessionariaRepositorio acaoConcessonaria;
    @Autowired
    private InstalacaoRepositorio acaoInstalacao;
    @Autowired
    private ContratoRepositorio acaoContrato;

    @GetMapping("/energias")
    public ModelAndView listarClientesAndView(){
        ModelAndView mv = new ModelAndView("energias");
        mv.addObject("clientes", acao.findClientes());
        return mv;
    }


    @GetMapping("/energias/novo")
    public String getEnergiaForm(Model model){
        List<Concessionaria> listConcessionarias = acaoConcessonaria.findAll(); 
        List<Cliente> listClientes = acaoCliente.findAll(); 
        List<Instalacao> listInstalacoes = acaoInstalacao.findAll(); 
        List<Contrato> listContratos = acaoContrato.findAll(); 
        model.addAttribute("energia", new Energia());
        model.addAttribute("listConcessionarias", listConcessionarias);
        model.addAttribute("listClientes", listClientes);
        model.addAttribute("listInstalacoes", listInstalacoes);
        model.addAttribute("listContratos", listContratos);
        return "energiaForm";
    }
}
