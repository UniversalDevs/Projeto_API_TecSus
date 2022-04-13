package com.spring.TecSUS.repository;

import com.spring.TecSUS.model.Contrato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>{
    
}
