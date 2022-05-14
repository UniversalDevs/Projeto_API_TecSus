package com.spring.TecSUS.controle;

import java.util.List;

import com.google.common.net.MediaType;
import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Energia;
import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.ClienteRepositorio;
import com.spring.TecSUS.repositorio.ConcessionariaRepositorio;
import com.spring.TecSUS.repositorio.ContaRepositorio;
import com.spring.TecSUS.repositorio.ContratoRepositorio;
import com.spring.TecSUS.repositorio.EnergiaRepositorio;
import com.spring.TecSUS.repositorio.InstalacaoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;


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

    @Autowired
    private ContaRepositorio acaoConta;

    @GetMapping("/energias")
    public ModelAndView listarClientesAndView(){
        ModelAndView mv = new ModelAndView("energias");
        mv.addObject("clientes", acao.findClientes());
        List<Concessionaria> concessionaria = acaoConcessonaria.findAll();
        mv.addObject("concessionarias", concessionaria);
        return mv;
    }


    @GetMapping("/energias/{contrato_id}/{codigo_identificador}/novo")
    public String getEnergiaForm(@PathVariable long contrato_id, @PathVariable long codigo_identificador,Model model){
        Contrato contrato = acaoContrato.findById(contrato_id);
        Conta conta = acaoConta.findConta();
        Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
        model.addAttribute("contrato", contrato);
        model.addAttribute("instalacao", instalacao);
        model.addAttribute("conta", conta); 
        return "energiaForm";
    }

    @PostMapping(value ="/energias/{contrato_id}/{codigo_identificador}/novo")
    public String cadastrarContaEnergia(@Validated Energia energia,BindingResult result, RedirectAttributes redirect, @PathVariable long codigo_identificador, @PathVariable long contrato_id){
        Contrato contrato = acaoContrato.findById(contrato_id);
        Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem","Verifique todos os campos!");
            return "/";

        }
        energia.setContrato(contrato);
        energia.setInstalacao(instalacao);
        energia.setCliente(contrato.getCliente());
        energia.setConcessionaria(contrato.getConcessionaria());
        acao.save(energia);
        redirect.addFlashAttribute("mensagem", "Arquivo Enviado com sucesso!");
        return "redirect:/energias";
    }

    //Descricao Clientes
    @GetMapping("/energias/concessionarias/{conc_id}")
    public ModelAndView clienteEnergia(@PathVariable long conc_id){
        ModelAndView mv = new ModelAndView("energiaConcessionariaCliente");
        Concessionaria concessionaria = acaoConcessonaria.findById(conc_id);
        List<Contrato> contratos = acaoContrato.findByConcessionaria(concessionaria);
        mv.addObject("contratos", contratos);
        return mv;
    }


    @GetMapping("/aguaForm")
    public String getaguaaForm(Model model){
     
        return "aguaForm";
    }
    @GetMapping("/visualizarContaAgua")
    public String gevisualizarContaAgua(Model model){
     
        return "visualizarContaAgua";
    }


    @GetMapping("/energias/concessionarias/cliente/{cli_id}")
    public  ModelAndView detalhesClienteEnergia(@PathVariable long cli_id){
        ModelAndView mv = new ModelAndView("energiaCliente");
        Cliente cliente =  acaoCliente.findById(cli_id);
        List<Instalacao> instalacoes = acaoInstalacao.findByCliente(cliente);
        // List<Instalacao> instalacoes = acaoInstalacao.findByContrato(contrato);
        mv.addObject("cliente", cliente);
        mv.addObject("instalacoes", instalacoes);
        return mv;
    }





}
