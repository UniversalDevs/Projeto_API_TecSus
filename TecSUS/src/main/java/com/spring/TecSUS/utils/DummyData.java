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
    //Testando Adicionando um novo comentario
    public void saveClientes(){
        List<Cliente> clienteList = new ArrayList<>();
        Cliente cli1 = new Cliente();
        cli1.setCli_nome("Guilherme Alves");
        cli1.setCli_dataNasc(LocalDate.of(2002, 2, 15));
        cli1.setCli_bairro("Tesouro");
        cli1.setCli_cep("12244-121");
        cli1.setCli_cidade("São José dos Campos");
        cli1.setCli_estado("São Paulo");
        cli1.setCli_rg("12.345.678-9");
        cli1.setCli_cpf("111.222.333-44");
        cli1.setCli_endereco("Rua dos Besouros");

        clienteList.add(cli1);

        for(Cliente cliente: clienteList){
            Cliente clienteSaved = clienteRepository.save(cliente);
            System.out.println(clienteSaved.getCli_id());
        }
    }
}
