package com.spring.TecSUS.repository;

import com.spring.TecSUS.model.Concessionaria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long>{
    
}
