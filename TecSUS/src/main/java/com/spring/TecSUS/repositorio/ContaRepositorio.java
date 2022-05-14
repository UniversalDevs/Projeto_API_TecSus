package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Conta;

import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Long>{
    List<Conta> findAll();
    Conta findById(long conta_id);    
    @Query(nativeQuery = true, value = "SELECT * FROM contas ORDER BY conta_id DESC LIMIT 1")
    Conta findConta();

}
