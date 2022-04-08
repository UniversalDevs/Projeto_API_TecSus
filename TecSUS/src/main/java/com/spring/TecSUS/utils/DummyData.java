package com.spring.TecSUS.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.spring.TecSUS.model.Cliente;
import com.spring.TecSUS.repository.ClienteRepository;


@Component
public class DummyData {
    
    @Autowired
    ClienteRepository clienteRepository;

    //@PostConstruct
    public void saveClientes(){
        List<Cliente> clienteList = new ArrayList<>();
        Cliente cli1 = new Cliente();
        cli1.setCli_nome("Felipe Augusto");
        cli1.setCli_dataNasc(LocalDate.of(2003, 3, 10));
        cli1.setCli_bairro("Campo");
        cli1.setCli_cep("12223-232");
        cli1.setCli_cidade("São José dos Campos");
        cli1.setCli_estado("São Paulo");
        cli1.setCli_rg("56.433.434-3");
        cli1.setCli_cpf("233.323.232-23");
        cli1.setCli_endereco("Rua dos Camundongos");

        clienteList.add(cli1);

        for(Cliente cliente: clienteList){
            Cliente clienteSaved = clienteRepository.save(cliente);
            System.out.println(clienteSaved.getCli_id());
        }
    }
}
