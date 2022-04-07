package com.spring.TecSUS.repository;

import com.spring.TecSUS.model.Instalacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacaoRepository extends JpaRepository<Instalacao, Long>{
    
}