package com.spring.TecSUS.service;

import java.util.List;

import com.spring.TecSUS.model.Contrato;

import org.springframework.stereotype.Service;


@Service
public interface ContratoService {
    
    List<Contrato> findAll();
    Contrato findById(long id);
    Contrato save(Contrato contrato);

}
