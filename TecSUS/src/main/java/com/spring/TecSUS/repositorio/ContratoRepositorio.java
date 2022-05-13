package com.spring.TecSUS.repositorio;
import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Concessionaria;
import com.spring.TecSUS.modelo.Contrato;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepositorio extends CrudRepository<Contrato, Long>{
    List<Contrato> findAll();
    Contrato findById(long contrato_id);
    List<Contrato> findByConcessionaria(Concessionaria concessionaria);
    List<Contrato> findByCliente(Cliente cliente);

}
