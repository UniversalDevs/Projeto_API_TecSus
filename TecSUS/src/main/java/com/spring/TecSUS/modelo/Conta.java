package com.spring.TecSUS.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.querydsl.sql.Column;

import aj.org.objectweb.asm.Type;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conta_id;

    private String name;

    private long size;

    private Date uploadTime;

    private String type;

    @Lob
    private byte[] content;

    @ManyToOne
    @JoinColumn(name =  "cli_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name =  "conc_id", nullable = false)
    private Concessionaria concessionaria;


    @ManyToOne
    @JoinColumn(name =  "codigo_identificador", nullable = false)
    private Instalacao instalacao;

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Concessionaria getConcessionaria() {
        return concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public Long getConta_id() {
        return conta_id;
    }

    public void setConta_id(Long conta_id) {
        this.conta_id = conta_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    
    
}
