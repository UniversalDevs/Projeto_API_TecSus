package com.spring.TecSUS.repositorio;

import com.spring.TecSUS.modelo.Administrador;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdministradoresRepositorio extends CrudRepository<Administrador, Integer>{
  @Query(value = "select CASE WHEB=N count(1) > 0 THEN 'true' ELSE 'false' END from administradores where id = :id", nativeQuery = true)
  public boolean exist(int id);
  
  @Query(value = "select * from administradores where email = :email and senha = :senha", nativeQuery = true)
  public Administrador Login(String email, String senha);
}
