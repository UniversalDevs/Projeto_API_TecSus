package com.spring.TecSUS.controle;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.ClienteRepositorio;
import com.spring.TecSUS.repositorio.ContaRepositorio;
import com.spring.TecSUS.repositorio.ContratoRepositorio;
import com.spring.TecSUS.repositorio.InstalacaoRepositorio;
import com.spring.TecSUS.servico.ArmazemConta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContaControle {
    @Autowired
    private ContaRepositorio acao;

    @Autowired
    private ClienteRepositorio acaoCliente;

    @Autowired
    private InstalacaoRepositorio acaoInstalacao;

    @Autowired
    private ContratoRepositorio acaoContrato;

    @Autowired
    private ArmazemConta armazem;

    @GetMapping("/energias/contas")
    public ModelAndView listarContas(){
        ModelAndView mv = new ModelAndView("contas");
        List<Conta> contas = acao.findAll();
        mv.addObject("contas", contas);
        return mv;
    }


    
    @RequestMapping(value = "/energias/contas/novo", method = RequestMethod.GET)
    public String getClienteForm(){
        return "contaForm";
    }

    @GetMapping("energia/clientes/{cli_id}")
    public ModelAndView detalhesClienteConta(@PathVariable("cli_id") long cli_id) {
        ModelAndView mv =  new ModelAndView("detalhesCliente");
        Cliente cliente = acaoCliente.findById(cli_id);
        mv.addObject("cliente", cliente);
        return mv;
    }

    @GetMapping("/energias/concessionarias/cliente/conta/{codigo_identificador}")
    public ModelAndView cadastrarConta(@PathVariable long codigo_identificador){
        ModelAndView mv = new ModelAndView("contaForm");
        Instalacao instalacao = acaoInstalacao.findById(codigo_identificador);
        Instalacao dados = acaoInstalacao.findDados(codigo_identificador);
        mv.addObject("dados", dados);
        mv.addObject("instalacao", instalacao);

        return mv;
    }

    @PostMapping("/energias/concessionarias/cliente/conta/upload/{contrato_id}/{codigo_identificador}")
    public String uploadFile(@PathVariable long contrato_id,@PathVariable long codigo_identificador,@RequestParam("document") MultipartFile multipartFile, RedirectAttributes ra) throws IOException{
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
        acao.save(conta);

        ra.addFlashAttribute("mensagem", "Arquivo Enviado com sucesso!");

        return "redirect:/energias/{contrato_id}/{codigo_identificador}/novo";
    }

    @GetMapping("/conta/{conta_id}")
    public ResponseEntity<Resource> obterArquivo(@PathVariable long conta_id){
        Resource recurso = armazem.obterContaComoRecurso(conta_id);
        if(recurso == null) {
            ResponseEntity<Resource> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return resposta;
        }
        else{
            Conta conta = acao.findById(conta_id);
            MediaType tipoArquivo = MediaType.parseMediaType(conta.getType());
            ResponseEntity<Resource> resposta = ResponseEntity.ok().contentType(tipoArquivo).body(recurso);
            return resposta;
        }
    }

    @GetMapping("/download_conta")
    public void downloadConta(HttpServletResponse response) throws IOException {
        Conta conta = acao.findConta();

        response.setContentType(conta.getType());
        String headerKey = "Content-Disposition";
        String headerValue = "inline; filename=" + conta.getName();

        response.setHeader(headerKey, headerValue);

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(conta.getContent());
    }
}