package com.spring.TecSUS.repository;

import com.spring.TecSUS.model.FileUpload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileUpload,Integer>{
    
}
