package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Long>{
    List<Conta> findAll();
    Conta findById(long conta_id);
    
}
