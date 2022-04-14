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

// Dados necessarios para cadastro de Concessionarias. 
@Entity
@Table(name="TB_CONCESSIONARIA")
public class Concessionaria {
    

    //verificar se campo ID é necessário, já que o CNPJ já é um dado único. 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long concessionaria_id;

    @NotBlank
    private String concessionaria_cnpj;
    
    @NotBlank
    private String concessionaria_IE; //Inscrição Estatudal
    
    @NotBlank
    private String concessionaria_inscricao_unica_reg;     //Inscrição unica de registro.  mudar nome da variavel. 
    
    @NotBlank
    private String concessionaria_processo;

    @NotBlank
    private String concessionaria_nome; 

    @NotBlank
    private String concessionaria_end;  //endereço

    @NotBlank
    private String concessionaria_cxpst; //caixa postal. 

    @NotBlank
    private String concessionaria_cep;

    @NotBlank
    private String concessionaria_cidade;

    @NotBlank
    private String concessionaria_estado;

    public Long getConcessionaria_id() {
        return concessionaria_id;
    }

    public void setConcessionaria_id(Long concessionaria_id) {
        this.concessionaria_id = concessionaria_id;
    }

    public String getConcessionaria_cnpj() {
        return concessionaria_cnpj;
    }

    public void setConcessionaria_cnpj(String concessionaria_cnpj) {
        this.concessionaria_cnpj = concessionaria_cnpj;
    }

    public String getConcessionaria_IE() {
        return concessionaria_IE;
    }

    public void setConcessionaria_IE(String concessionaria_IE) {
        this.concessionaria_IE = concessionaria_IE;
    }

    public String getConcessionaria_inscricao_unica_reg() {
        return concessionaria_inscricao_unica_reg;
    }

    public void setConcessionaria_inscricao_unica_reg(String concessionaria_inscricao_unica_reg) {
        this.concessionaria_inscricao_unica_reg = concessionaria_inscricao_unica_reg;
    }

    public String getConcessionaria_processo() {
        return concessionaria_processo;
    }

    public void setConcessionaria_processo(String concessionaria_processo) {
        this.concessionaria_processo = concessionaria_processo;
    }

    public String getConcessionaria_nome() {
        return concessionaria_nome;
    }

    public void setConcessionaria_nome(String concessionaria_nome) {
        this.concessionaria_nome = concessionaria_nome;
    }

    public String getConcessionaria_end() {
        return concessionaria_end;
    }

    public void setConcessionaria_end(String concessionaria_end) {
        this.concessionaria_end = concessionaria_end;
    }

    public String getConcessionaria_cxpst() {
        return concessionaria_cxpst;
    }

    public void setConcessionaria_cxpst(String concessionaria_cxpst) {
        this.concessionaria_cxpst = concessionaria_cxpst;
    }

    public String getConcessionaria_cep() {
        return concessionaria_cep;
    }

    public void setConcessionaria_cep(String concessionaria_cep) {
        this.concessionaria_cep = concessionaria_cep;
    }

    public String getConcessionaria_cidade() {
        return concessionaria_cidade;
    }

    public void setConcessionaria_cidade(String concessionaria_cidade) {
        this.concessionaria_cidade = concessionaria_cidade;
    }

    public String getConcessionaria_estado() {
        return concessionaria_estado;
    }

    public void setConcessionaria_estado(String concessionaria_estado) {
        this.concessionaria_estado = concessionaria_estado;
    }
}


    //Getters and Setters
     
    