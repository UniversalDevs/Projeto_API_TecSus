package com.spring.TecSUS.controle;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Instalacao;
import com.spring.TecSUS.repositorio.ClienteRepositorio;
import com.spring.TecSUS.repositorio.ContratoRepositorio;
import com.spring.TecSUS.repositorio.InstalacaoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraficosControle {
    
    @Autowired
    private ContratoRepositorio acaoContrato;

    @Autowired
    private InstalacaoRepositorio acaoInstalacao;

    @Autowired 
    private ClienteRepositorio acaoCliente;

    @GetMapping("/relatorio/{cli_id}")
    public List<Instalacao> unidades(@PathVariable long cli_id){
        Cliente cliente = acaoCliente.findById(cli_id); 
        List<Instalacao> unidades = acaoInstalacao.findByCliente(cliente);

        return unidades;
        
    }
}
