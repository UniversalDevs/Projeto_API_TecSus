package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Energia;

import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EnergiaRepositorio extends CrudRepository<Energia, Long>{
    List<Energia> findAll();
    Energia findById(long energia_id);
    @Query(nativeQuery = true,value = "SELECT c.cli_id, c.cli_nome, conc.conc_id, conc.conc_nome, ct.tipo_servico FROM clientes c, contratos ct, concessionarias conc WHERE ct.cli_id = c.cli_id AND ct.tipo_servico = 'Energia';")
    List<Object[]> findClientes();
    List<Energia> findByContratoOrderByAno(Contrato contrato);
    List<Energia> findByContrato(Contrato contrato);
    @Query(nativeQuery= true, value ="SELECT * FROM energias GROUP BY ano")
    List<Energia> findContasAno();
    

}
