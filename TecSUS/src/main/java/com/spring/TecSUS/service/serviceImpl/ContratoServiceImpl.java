package com.spring.TecSUS.service.serviceImpl;

import java.util.List;

import com.spring.TecSUS.model.Contrato;
import com.spring.TecSUS.repository.ContratoRepository;
import com.spring.TecSUS.service.ContratoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoServiceImpl implements ContratoService{

    @Autowired
    ContratoRepository contratoRepository;

    @Override
    public List<Contrato> findAll() {
        return contratoRepository.findAll();
    }

    @Override
    public Contrato findById(long id) {
        return contratoRepository.findById(id).get();
    }

    @Override
    public Contrato save(Contrato contrato) {
        return contratoRepository.save(contrato);
    }
           
}
