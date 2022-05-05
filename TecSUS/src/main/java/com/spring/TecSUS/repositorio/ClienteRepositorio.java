package com.spring.TecSUS.repositorio;


import java.util.List;

import com.spring.TecSUS.modelo.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();
    Cliente findById(long cli_id);
}

