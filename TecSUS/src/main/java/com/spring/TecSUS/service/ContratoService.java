package com.spring.TecSUS.service;

import java.util.List;

import com.spring.TecSUS.model.Contrato;

import org.springframework.stereotype.Service;

import net.bytebuddy.TypeCache.Sort;


@Service
public interface ContratoService {
    
    List<Contrato> findAll();
    Contrato findById(long id);
    Contrato save(Contrato contrato);

}
