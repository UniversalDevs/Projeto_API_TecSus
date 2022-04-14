package com.spring.TecSUS.service;

import java.util.List;

import com.spring.TecSUS.model.Instalacao;

public interface InstalacaoService {

    List<Instalacao> findAll();
    Instalacao findById(long id);
    Instalacao save(Instalacao instalacao);
}