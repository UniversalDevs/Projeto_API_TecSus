package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Energia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EnergiaRepositorio extends CrudRepository<Energia, Long>{
    List<Energia> findAll();
    Energia findById(long energia_id);
    @Query(nativeQuery = true,value = "SELECT c.cli_id, c.cli_nome,  ct.tipo_servico, con.conc_nome, i.codigo_identificador from concessionarias con, contratos ct, clientes c, instalacoes i WHERE ct.tipo_servico='Energia' AND ct.cli_id = c.cli_id AND ct.contrato_id=i.contrato_id;")
    List<Object[]> findClientes();

}
