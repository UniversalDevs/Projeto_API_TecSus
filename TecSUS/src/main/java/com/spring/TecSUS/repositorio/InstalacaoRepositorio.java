package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Cliente;
import com.spring.TecSUS.modelo.Contrato;
import com.spring.TecSUS.modelo.Instalacao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacaoRepositorio extends CrudRepository<Instalacao, Long>{
    List<Instalacao> findAll();
    Instalacao findById(long codigo_identificador);
    List<Instalacao> findByContrato(Contrato contrato);
    List<Instalacao> findByCliente(Cliente cliente);
    @Query(nativeQuery = true, value = "SELECT contrato.*, i.*, c.*, con.* from contratos contrato, clientes c, instalacoes i, concessionarias con WHERE i.codigo_identificador = :codigo_identificador  AND c.cli_id = contrato.cli_id AND i.contrato_id = contrato.contrato_id AND contrato.conc_id = con.conc_id")
    Instalacao findDados(long codigo_identificador);

    @Query(nativeQuery = true, value = "SELECT i.* FROM contratos c, instalacoes i, clientes cli WHERE i.contrato_id= :contrato_id AND c.tipo_servico='Água'")
    List<Instalacao> findInstalacoes(long contrato_id);
}
