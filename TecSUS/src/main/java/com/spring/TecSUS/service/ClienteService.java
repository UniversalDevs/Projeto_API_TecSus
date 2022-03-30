package com.spring.TecSUS.service;

import java.util.List;

import com.spring.TecSUS.model.Cliente;

public interface ClienteService {
    
    List<Cliente> findAll();
    Cliente findById(long id);
    Cliente save(Cliente cliente);
}
