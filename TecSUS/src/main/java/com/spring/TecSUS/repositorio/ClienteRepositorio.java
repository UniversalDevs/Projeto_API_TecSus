package com.spring.TecSUS.repositorio;


import java.util.List;

import com.spring.TecSUS.modelo.Cliente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();
    Cliente findById(long cli_id);
    @Query(nativeQuery = true,value = "SELECT c.cli_nome, c.cli_id, ct.tipo_servico from contratos ct, clientes c WHERE ct.tipo_servico='Energia' AND ct.cli_id = c.cli_id")
    List<Cliente> findClientes();
}

