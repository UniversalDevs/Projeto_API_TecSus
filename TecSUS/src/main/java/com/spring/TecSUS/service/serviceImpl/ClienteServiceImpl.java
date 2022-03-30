package com.spring.TecSUS.service.serviceImpl;

import java.util.List;

import com.spring.TecSUS.model.Cliente;
import com.spring.TecSUS.repository.ClienteRepository;
import com.spring.TecSUS.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
}
