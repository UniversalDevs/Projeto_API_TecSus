package com.spring.TecSUS.repositorio;

import java.util.List;

import com.spring.TecSUS.modelo.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
    List<Usuario> findAll();

}
