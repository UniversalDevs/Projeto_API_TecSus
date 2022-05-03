package com.spring.TecSUS.repository;

import java.util.List;

import com.spring.TecSUS.model.Contrato;
import com.spring.TecSUS.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import net.bytebuddy.TypeCache.Sort;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{
    List<Contrato> findByCliente(Cliente cliente, Sort sort);
}
