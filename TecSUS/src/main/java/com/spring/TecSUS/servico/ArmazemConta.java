package com.spring.TecSUS.servico;

import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.repositorio.ContaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ArmazemConta {
    @Autowired
    private ContaRepositorio repositorio;

    public Resource obterContaComoRecurso(Long conta_id){
        Conta conta = this.repositorio.getById(conta_id);
        Resource recurso = new ByteArrayResource(conta.getContent());
        return recurso;
    }
    
    
}
