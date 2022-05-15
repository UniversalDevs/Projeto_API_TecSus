package com.spring.TecSUS.controle;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.spring.TecSUS.modelo.Agua;
import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.AguaRepositorio;
import com.spring.TecSUS.repositorio.ClienteRepositorio;
import com.spring.TecSUS.repositorio.ConcessionariaRepositorio;
import com.spring.TecSUS.repositorio.ContaRepositorio;
import com.spring.TecSUS.repositorio.ContratoRepositorio;
import com.spring.TecSUS.repositorio.InstalacaoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AguaControle {
    @Autowired
    private AguaRepositorio acao;
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

    @GetMapping("/aguas")
    public ModelAndView listarClientes(){
        ModelAndView mv = new ModelAndView("aguas");
        mv.addObject("clientes", acao.findClientes());
        List<Contrato> concessionarias = acaoContrato.findConcessionaria();
        mv.addObject("concessionarias", concessionarias);
        return mv;
    }

        //Lista de Clientes
        @GetMapping("/aguas/concessionarias/{conc_id}")
        public ModelAndView clienteAgua(@PathVariable long conc_id){
            ModelAndView mv = new ModelAndView("aguaConcessionariaCliente");
            Concessionaria concessionaria = acaoConcessonaria.findById(conc_id);
            List<Contrato> contratos = acaoContrato.findByConcessionaria(concessionaria);
            mv.addObject("contratos", contratos);
            return mv;
        }
        
        //Listar Cliente por Concessionária
        @GetMapping("/aguas/concessionarias/cliente/{contrato_id}/{cli_id}")
        public  ModelAndView detalhesClienteagua(@PathVariable long cli_id, @PathVariable long contrato_id){
            ModelAndView mv = new ModelAndView("aguaCliente");
            Cliente cliente = acaoCliente.findById(cli_id);
            Contrato contrato = acaoContrato.findById(contrato_id);
            List<Instalacao> instalacoes = acaoInstalacao.findByContrato(contrato);
            List<Agua> contasAgua = acao.findByContrato(contrato);
            mv.addObject("contas", contasAgua);
            mv.addObject("contrato", contrato);
            mv.addObject("cliente", cliente);
            mv.addObject("instalacoes", instalacoes);
            return mv;
        }

        //Form Conta de agua
        @GetMapping("/aguas/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo")
        public String getaguaForm(@PathVariable long contrato_id, @PathVariable long codigo_identificador,Model model){
            Contrato contrato = acaoContrato.findById(contrato_id);
            Conta conta = acaoConta.findConta();
            Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
            model.addAttribute("contrato", contrato);
            model.addAttribute("instalacao", instalacao);
            model.addAttribute("conta", conta); 
            return "aguaForm";
        }

        @GetMapping("/aguas/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}")
        public ModelAndView cadastrarConta(@PathVariable long contrato_id, @PathVariable long cli_id,@PathVariable long codigo_identificador){
            ModelAndView mv = new ModelAndView("contaFormAgua");
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

        @PostMapping("/aguas/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/upload")
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
    
            return "redirect:/aguas/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo";
        }

        //Salvar conta cadastrada
        @PostMapping(value ="/aguas/concessionarias/cliente/{contrato_id}/{cli_id}/conta/{codigo_identificador}/novo")
        public String cadastrarContaAgua(@Validated Agua agua,BindingResult result, RedirectAttributes redirect, @PathVariable long codigo_identificador, @PathVariable long contrato_id){
            Contrato contrato = acaoContrato.findById(contrato_id);
            Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
            if(result.hasErrors()){
                redirect.addFlashAttribute("mensagem","Verifique todos os campos!");
                return "/";
                
            }
            agua.setContrato(contrato);
            agua.setInstalacao(instalacao);
            agua.setCliente(contrato.getCliente());
            agua.setConcessionaria(contrato.getConcessionaria());
            acao.save(agua);
            redirect.addFlashAttribute("mensagem", "Arquivo Enviado com sucesso!");
            return "redirect:/aguas/concessionarias/cliente/{contrato_id}/{cli_id}  ";
        }

        @GetMapping("/aguas/visualizarContaAgua")
        public ModelAndView VisualizarConta(){
            ModelAndView mv = new ModelAndView("visualizarContaAgua");
            mv.addObject("clientes", acao.findClientes());
            List<Contrato> concessionarias = acaoContrato.findConcessionaria();
            List<Conta> contas = acaoConta.findAll();
            mv.addObject("contas", contas);
            mv.addObject("concessionarias", concessionarias);
            return mv;
        }
}
