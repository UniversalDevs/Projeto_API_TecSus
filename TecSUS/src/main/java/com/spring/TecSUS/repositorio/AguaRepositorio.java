package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Agua;
import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Contrato;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AguaRepositorio extends CrudRepository<Agua, Long>{
    List<Agua> findAll();
    Agua findById(long agua_id);
    @Query(nativeQuery = true,value = "SELECT c.cli_id, c.cli_nome, conc.conc_id, conc.conc_nome, ct.tipo_servico FROM clientes c, contratos ct, concessionarias conc WHERE ct.cli_id = c.cli_id AND ct.tipo_servico = 'Água';")
    List<Object[]> findClientes();
    List<Agua> findByContrato(Contrato contrato);
    List<Agua> findByCliente(Cliente cliente);

}
