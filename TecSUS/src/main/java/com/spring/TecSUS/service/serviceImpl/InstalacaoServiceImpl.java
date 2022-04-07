package com.spring.TecSUS.service.serviceImpl;

import java.util.List;

import com.spring.TecSUS.model.Instalacao;
import com.spring.TecSUS.repository.InstalacaoRepository;
import com.spring.TecSUS.service.InstalacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class InstalacaoServiceImpl implements InstalacaoService {

    @Autowired
    InstalacaoRepository InstalacaoRepository;

    @Override
    public List<Instalacao> findAll() {
        return InstalacaoRepository.findAll();
    }

    @Override
    public Instalacao findById(long id) {
        return InstalacaoRepository.findById(id).get();
    }

    @Override
    public Instalacao save(Instalacao Instalacao) {
        return InstalacaoRepository.save(Instalacao);
    }
    
}