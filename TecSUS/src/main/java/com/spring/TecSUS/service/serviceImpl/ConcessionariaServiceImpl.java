package com.spring.TecSUS.service.serviceImpl;

import java.util.List;

import com.spring.TecSUS.model.Concessionaria;
import com.spring.TecSUS.repository.ConcessionariaRepository;
import com.spring.TecSUS.service.ConcessionariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class ConcessionariaServiceImpl implements ConcessionariaService {
//public class ConcessionariaServiceImpl implements ConcessionariaService {

    @Autowired
    ConcessionariaRepository concessionariaRepository;

    @Override
    public List<Concessionaria> findAll() {
        return concessionariaRepository.findAll();
    }

    @Override
    public Concessionaria findById(long id) {
        return concessionariaRepository.findById(id).get();
    }

    @Override
    public Concessionaria save(Concessionaria concessionaria) {
        return concessionariaRepository.save(concessionaria);
    }
    
}
