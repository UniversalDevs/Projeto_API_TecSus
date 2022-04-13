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
    public void saveConcessionarias(){
        List<Concessionaria> ConcessionariaList = new ArrayList<>();
        Concessionaria con2 = new Concessionaria();
        con2.setConcessionaria_cep("01107900");
        con2.setConcessionaria_nome("SABESPSP");
        con2.setConcessionaria_endereco("Avenida do Estado 561");
        con2.setConcessionaria_cidade("São Paulo");
        con2.setConcessionaria_estado("SP");
        con2.setconcessionaria_modalidade("Água");

        ConcessionariaList.add(con2);

        for(Concessionaria Concessionaria: ConcessionariaList){
            Concessionaria Concessionariasaved = ConcessionariaRepository.save(Concessionaria);
            System.out.println(Concessionariasaved.getConcessionaria_id());
        }
    }
}
