package com.spring.TecSUS.service;

import java.util.List;

import com.spring.TecSUS.model.Concessionaria;

public interface ConcessionariaService {
    
    List<Concessionaria> findAll();
    Concessionaria findById(long id);
    Concessionaria save(Concessionaria concessionaria);
}
