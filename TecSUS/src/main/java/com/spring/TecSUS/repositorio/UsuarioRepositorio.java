package com.spring.TecSUS.repositorio;

import com.spring.TecSUS.modelo.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{
    
}
