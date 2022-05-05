package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Concessionaria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariaRepositorio extends CrudRepository<Concessionaria, Long>{
    List<Concessionaria> findAll();
    Concessionaria findById(long conc_id);
}

