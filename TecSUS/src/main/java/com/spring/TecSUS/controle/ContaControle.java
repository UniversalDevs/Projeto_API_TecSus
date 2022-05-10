package com.spring.TecSUS.controle;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.repositorio.ContaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/energias/contas")
    public ModelAndView listarContas(){
        ModelAndView mv = new ModelAndView("contas");
        List<Conta> contas = acao.findAll();
        mv.addObject("contas", contas);
        return mv;
    }

    @PostMapping("/energias/contas/upload")
    public String cadastrarConta(@RequestParam("conta") MultipartFile multipartFile, RedirectAttributes redirect) throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Conta conta = new Conta();
        conta.setName(fileName);
        conta.setContent(multipartFile.getBytes());
        conta.setSize(multipartFile.getSize());
        // conta.setUploadTime(new Date());
        acao.save(conta);
        return "redirect:/energias/contas/novo";
    }

    @RequestMapping(value = "/energias/contas/novo", method = RequestMethod.GET)
    public String getClienteForm(){
        return "contaForm";
    }
}
