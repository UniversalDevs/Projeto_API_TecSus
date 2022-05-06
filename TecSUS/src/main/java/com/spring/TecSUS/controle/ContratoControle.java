package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.repositorio.ClienteRepositorio;
import com.spring.TecSUS.repositorio.ConcessionariaRepositorio;
import com.spring.TecSUS.repositorio.ContratoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContratoControle {
    
    @Autowired
    private ContratoRepositorio acao;
    @Autowired
    private ClienteRepositorio acaoCliente;
    @Autowired
    private ConcessionariaRepositorio acaoConcessonaria;

    //Cadastro de Contratos

 

    // @PostMapping("/contratos/novo")
    // public String cadastrarContrato(@Validated Contrato contrato, BindingResult result, RedirectAttributes redirect){
    //     if(result.hasErrors()){
    //         redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
    //         return "redirect:/contrato/novo";
    //     }
        
    //     acao.save(contrato);
    //     return "redirect:/contratos";
    // }

    @GetMapping("/contratos/novo")
    public String getContratoForm(Model model){
        List<Concessionaria> listConcessionarias = acaoConcessonaria.findAll();
        List<Cliente> listClientes = acaoCliente.findAll();
        model.addAttribute("contrato", new Contrato());
        model.addAttribute("listConcessionarias", listConcessionarias);
        model.addAttribute("listClientes", listClientes);
        return "contratoForm";
    }

    //Listar os Contratos
    @GetMapping("/contratos")
    public ModelAndView listarContratos(){
        ModelAndView mv = new ModelAndView("contratos");
        List<Contrato> contratos = acao.findAll();
        mv.addObject("contratos", contratos);
        return mv;
    }

    //Descrição dos Dados do Contrato
    @GetMapping("/contratos/{contrato_id}")
    public ModelAndView detalhesContrato(@PathVariable long contrato_id){
        ModelAndView mv = new ModelAndView("detalhesContrato");
        Contrato contrato = acao.findById(contrato_id);
        mv.addObject("contrato", contrato);
        return mv;
    }

        //Editar contrato
        @PutMapping("/contrato/editar")
        public Contrato editarContrato(@RequestBody Contrato obj){
            return acao.save(obj);
        }

        //Contar Contratos
         @GetMapping("/contrato/quantidade")
        public long contarContratos(){
            return acao.count();
        }



        @PostMapping("/contrato")
        public Contrato contrato(@RequestBody Contrato contrato){
            return contrato;
        }

        // @GetMapping("/contratos/novo")
        // public ModelAndView listarClientes(){
        //     ModelAndView mv = new ModelAndView("contratoForm");
        //     List<Cliente> clientes = acaoCliente.findAll();
        //     mv.addObject("clientes",clientes);
        //     return mv;
        // }
        @PostMapping("/contratos/save")
        public String saveContrato(Contrato contrato) {
            acao.save(contrato);
            return "redirect:/contratos";
        }
    
}
