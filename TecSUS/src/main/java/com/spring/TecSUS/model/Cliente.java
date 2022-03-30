package com.spring.TecSUS.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;


@Entity
@Table(name="TB_CLIENTE")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cli_id;

    @NotBlank
    private String cli_nome;

    @NotBlank
    private String cli_rg;

    @NotBlank
    private String cli_cpf;

    @NotBlank
    private String cli_cep;

    @NotBlank
    private String cli_endereco;

    @NotBlank
    private String cli_cidade;

    @NotBlank
    private String cli_estado;

    @NotBlank
    private String cli_bairro;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate cli_dataNasc;


    //Getters and Setters
     
    public Long getCli_id(){
        return cli_id;
    }

    public void setCli_id(Long cli_id){
        this.cli_id = cli_id;
    }
    public LocalDate getCli_dataNasc() {
        return cli_dataNasc;
    }

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_rg() {
        return cli_rg;
    }

    public void setCli_rg(String cli_rg) {
        this.cli_rg = cli_rg;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }

    public String getCli_cidade() {
        return cli_cidade;
    }

    public void setCli_cidade(String cli_cidade) {
        this.cli_cidade = cli_cidade;
    }

    public String getCli_estado() {
        return cli_estado;
    }

    public void setCli_estado(String cli_estado) {
        this.cli_estado = cli_estado;
    }

    public String getCli_bairro() {
        return cli_bairro;
    }

    public void setCli_bairro(String cli_bairro) {
        this.cli_bairro = cli_bairro;
    }

    public void setCli_dataNasc(LocalDate cli_dataNasc) {
        this.cli_dataNasc = cli_dataNasc;
    }


}
