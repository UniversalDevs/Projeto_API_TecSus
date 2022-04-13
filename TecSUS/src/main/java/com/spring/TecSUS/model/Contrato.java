package com.spring.TecSUS.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import org.springframework.jmx.export.annotation.ManagedOperation;

@Entity
@Table(name="TB_CONTRATO")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contrato_id;

    @OneToMany
    @NotBlank
    private String contrato_cli;

    @OneToMany
    @NotBlank
    private String contrato_con;
    
}