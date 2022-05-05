package com.spring.TecSUS.controle;


import java.util.List;

import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.repositorio.ConcessionariaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConcessionariaControle {
    
    @Autowired
    private ConcessionariaRepositorio acao;

        //Cadastro de Concessionarias
        @PostMapping("/concessionarias/novo")
        public String cadastrarCliente(@Validated Concessionaria cliente, BindingResult result, RedirectAttributes redirect){
            if(result.hasErrors()){
                redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
                return "redirect:/concessionarias/novo";
            }
            acao.save(cliente);
            return "redirect:/concessionarias";
        }

        @RequestMapping(value = "/concessionarias/novo", method = RequestMethod.GET)
        public String getConcessionariaForm(){
            return "concessionariaForm";
        }

        //Listar os Clientes
        @GetMapping("/concessionarias")
        public ModelAndView listarConcessionarias(){
            ModelAndView mv = new ModelAndView("concessionarias");
            List<Concessionaria> concessionarias = acao.findAll();
            mv.addObject("concessionarias",concessionarias);
            return mv;
        }

        //Descricao dos Dados do Concessionarias
        @GetMapping("/concessionarias/{conc_id}")
        public ModelAndView detalhesConcessionaria(@PathVariable long conc_id){
            ModelAndView mv = new ModelAndView("detalhesConcessionaria");
            Concessionaria concessionaria = acao.findById(conc_id);
            mv.addObject("concessionaria", concessionaria);
            return mv;
    }

}