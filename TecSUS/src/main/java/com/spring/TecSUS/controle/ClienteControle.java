package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.repositorio.ClienteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ClienteControle {

    @Autowired
    private ClienteRepositorio acao;

    //Cadastro de Clientes
    @PostMapping("/clientes/novo")
    public String cadastrarCliente(@Validated Cliente cliente, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
            return "redirect:/cliente/novo";
        }
        acao.save(cliente);
        return "redirect:/clientes";
    }

    @RequestMapping(value = "/clientes/novo", method = RequestMethod.GET)
    public String getClienteForm(){
        return "clienteForm";
    }
 
    //Listar os Clientes
    @GetMapping("/clientes")
    public ModelAndView listarClientes(){
        ModelAndView mv = new ModelAndView("clientes");
        List<Cliente> clientes = acao.findAll();
        mv.addObject("clientes",clientes);
        return mv;
    }

    //Descricao dos Dados do cliente
    @GetMapping("/clientes/{cli_id}")
    public ModelAndView detalhesCliente(@PathVariable long cli_id){
        ModelAndView mv = new ModelAndView("detalhesCliente");
        Cliente cliente = acao.findById(cli_id);
        mv.addObject("cliente", cliente);
        return mv;
    }

    //Editar cliente
    @PutMapping("/cliente/editar")
    public Cliente editarCliente(@RequestBody Cliente obj){
        return acao.save(obj);
    }

    // //Remover Cliente
    // @DeleteMapping("/cliente/excluir/{cli_id}")
    // public void remover(@PathVariable long cli_id){
    //     Cliente obj = detalhesCliente(cli_id);
    //     acao.delete(obj);
    // }

    //Contar Clientes
    @GetMapping("/cliente/quantidade")
    public long contarClientes(){
        return acao.count();
    }



    @PostMapping("/cliente")
    public Cliente cliente(@RequestBody Cliente c){
        return c;
    }
}

