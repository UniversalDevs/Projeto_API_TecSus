package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Instalacao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacaoRepositorio extends CrudRepository<Instalacao, Long>{
    List<Instalacao> findAll();
    Instalacao findById(long codigo_identificador);
    List<Instalacao> findByContrato(Contrato contrato);
}
