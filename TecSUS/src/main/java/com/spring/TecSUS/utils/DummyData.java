package com.spring.TecSUS.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.spring.TecSUS.model.Concessionaria;
import com.spring.TecSUS.repository.ConcessionariaRepository;


@Component
public class DummyData {
    
    @Autowired
    ConcessionariaRepository ConcessionariaRepository;

    //@PostConstruct
    //Testando Adicionando um novo comentario
<<<<<<< HEAD
    public void saveConcessionarias(){
        List<Concessionaria> ConcessionariaList = new ArrayList<>();
        Concessionaria con2 = new Concessionaria();
        con2.setConcessionaria_cep("01107900");
        con2.setConcessionaria_nome("SABESPSP");
        con2.setConcessionaria_endereco("Avenida do Estado 561");
        con2.setConcessionaria_cidade("São Paulo");
        con2.setConcessionaria_estado("SP");
        con2.setconcessionaria_modalidade("Água");
=======
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
>>>>>>> fe390b6002d1fe08790da4db22d69fbf2dd6b54d

        ConcessionariaList.add(con2);

        for(Concessionaria Concessionaria: ConcessionariaList){
            Concessionaria Concessionariasaved = ConcessionariaRepository.save(Concessionaria);
            System.out.println(Concessionariasaved.getConcessionaria_id());
        }
    }
}
