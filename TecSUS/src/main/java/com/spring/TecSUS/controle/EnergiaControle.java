package com.spring.TecSUS.controle;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.google.common.net.MediaType;
import com.spring.TecSUS.modelo.Agua;
import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Energia;
import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.AguaRepositorio;
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
import org.springframework.util.StringUtils;
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
import org.springframework.web.multipart.MultipartFile;


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

    @Autowired
    private AguaRepositorio acaoAgua;

    @GetMapping("/energias")
    public ModelAndView listarClientesAndView(){
        ModelAndView mv = new ModelAndView("energias");
        mv.addObject("clientes", acao.findClientes());
        List<Concessionaria> concessionaria = acaoConcessonaria.findAll();
        mv.addObject("concessionarias", concessionaria);
        return mv;
    }

        //Listas  Clientes
        @GetMapping("/energias/concessionarias/{conc_id}")
        public ModelAndView clienteEnergia(@PathVariable long conc_id){
            ModelAndView mv = new ModelAndView("energiaConcessionariaCliente");
            Concessionaria concessionaria = acaoConcessonaria.findById(conc_id);
            List<Contrato> contratos = acaoContrato.findByConcessionaria(concessionaria);
            mv.addObject("contratos", contratos);
            return mv;
        }

        //Listar Cliente por Concessionaria
        @GetMapping("/energias/concessionarias/cliente/{contrato_id}/{cli_id}")
        public  ModelAndView detalhesClienteEnergia(@PathVariable long cli_id, @PathVariable long contrato_id){
            ModelAndView mv = new ModelAndView("energiaCliente");
            Cliente cliente =  acaoCliente.findById(cli_id);
            Contrato contrato = acaoContrato.findById(contrato_id);
            List<Instalacao> instalacoes = acaoInstalacao.findByContrato(contrato);
            List<Energia> contasEnergia = acao.findByContrato(contrato);
            // List<Instalacao> instalacoes = acaoInstalacao.findByContrato(contrato);
            mv.addObject("contrato", contrato);
            mv.addObject("contas",contasEnergia);
            mv.addObject("cliente", cliente);
            mv.addObject("instalacoes", instalacoes);
            return mv;
        }

        //Get Mapping os dados do banco
        @GetMapping("/energias/concessionarias/cliente/{contrato_id}/{cli_id}/relatorios")
        public ModelAndView relatorio(@PathVariable long cli_id, @PathVariable long contrato_id){
            ModelAndView mv = new ModelAndView("RelatorioInstalacao");
            Cliente cliente = acaoCliente.findById(cli_id);
            Contrato contrato = acaoContrato.findById(contrato_id);
            List<Instalacao> instalacoes = acaoInstalacao.findByContrato(contrato);
            List<Energia> contasEnergias = acao.findByContrato(contrato);
            List<Agua> contAguas = acaoAgua.findByCliente(cliente);
            mv.addObject("cliente", cliente);
            mv.addObject("contrato", contrato);
            mv.addObject("instalacoes", instalacoes);
            mv.addObject("energia", contasEnergias);
            mv.addObject("agua", contAguas);
            return mv;
        }


        //Form conta de Energia 
        @GetMapping("/energias/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo")
        public String getenergiaForm(@PathVariable long contrato_id, @PathVariable long codigo_identificador,Model model){
            Contrato contrato = acaoContrato.findById(contrato_id);
            Conta conta = acaoConta.findConta();
            Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
            model.addAttribute("contrato", contrato);
            model.addAttribute("instalacao", instalacao);
            model.addAttribute("conta", conta); 
            return "energiaForm";
        }

        @GetMapping("/energias/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}")
        public ModelAndView cadastrarConta(@PathVariable long contrato_id, @PathVariable long cli_id,@PathVariable long codigo_identificador){
            ModelAndView mv = new ModelAndView("contaForm");
            Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
            Cliente cliente = acaoCliente.findById(cli_id);
            Instalacao dados = acaoInstalacao.findDados(codigo_identificador);
            Conta conta = acaoConta.findConta();
            mv.addObject("conta", conta);
            mv.addObject("cliente", cliente);
            mv.addObject("dados", dados);
            mv.addObject("instalacao", instalacao);
            return mv;
        }
        @PostMapping("/energias/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/upload")
        public String uploadFile(@PathVariable long contrato_id,@PathVariable long codigo_identificador,@PathVariable long cli_id,@RequestParam("document") MultipartFile multipartFile, RedirectAttributes ra) throws IOException{
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            Contrato contrato = acaoContrato.findById(contrato_id);
            Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
            Conta conta = new Conta();
            conta.setName(fileName);
            conta.setContent(multipartFile.getBytes());
            conta.setSize(multipartFile.getSize());
            conta.setUploadTime(Date.valueOf(LocalDate.now(ZoneId.of("UTC"))));
            conta.setCliente(contrato.getCliente());
            conta.setConcessionaria(contrato.getConcessionaria());
            conta.setInstalacao(instalacao);
            conta.setType(multipartFile.getContentType()); 
            acaoConta.save(conta);    
            ra.addFlashAttribute("mensagem", "Arquivo Enviado com sucesso!");
    
            return "redirect:/energias/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo";
        }

        //Salvar conta cadastrada
        @PostMapping(value ="/energias/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo")
        public String cadastrarContaAgua(@Validated Energia energia,BindingResult result, RedirectAttributes redirect, @PathVariable long codigo_identificador, @PathVariable long contrato_id){
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
            return "redirect:/energias/concessionarias/cliente/{contrato_id}/{cli_id}  ";
        }

    // @PostMapping(value ="/energias/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo")
    // public String cadastrarContaEnergia(@Validated Energia energia,BindingResult result, RedirectAttributes redirect, @PathVariable long codigo_identificador, @PathVariable long contrato_id){
    //     Contrato contrato = acaoContrato.findById(contrato_id);
    //     Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);

    //     if(result.hasErrors()){
    //         redirect.addFlashAttribute("mensagem","Verifique todos os campos!");
    //         return "/";

    //     }
    //     energia.setContrato(contrato);
    //     energia.setInstalacao(instalacao);
    //     energia.setCliente(contrato.getCliente());
    //     energia.setConcessionaria(contrato.getConcessionaria());
    //     acao.save(energia);
    //     redirect.addFlashAttribute("mensagem", "Arquivo Enviado com sucesso!");
    //     return "redirect:/energias";
    // }







    @GetMapping("/aguaForm")
    public String getaguaaForm(Model model){
     
        return "aguaForm";
    }
    @GetMapping("/visualizarContaAgua")
    public String gevisualizarContaAgua(Model model){
     
        return "visualizarContaAgua";
    }


    






}
