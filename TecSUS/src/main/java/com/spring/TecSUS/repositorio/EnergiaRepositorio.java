package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Energia;

import org.springframework.data.repository.CrudRepository;

public interface EnergiaRepositorio extends CrudRepository<Energia, Long>{
    List<Energia> findAll();
    Energia findById(long energia_id);
}
