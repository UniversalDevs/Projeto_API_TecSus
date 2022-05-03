package com.spring.TecSUS.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.servlet.FlashMapManager;

@Entity
@Table(name="TB_CONTRATO")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contrato_id;

    @NotBlank
    private String tipo_servico;

    @ManyToOne
    @JoinColumn(name =  "cli_id", nullable = false)
    private Cliente cliente;

    // @OneToOne
    // @JoinColumn(name = "concessionaria_id")
    // private Concessionaria concessionaria;

    @NotBlank
    private String endereco;

    @NotBlank
    private String cep;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    public Long getContrato_id() {
        return contrato_id;
    }

    public void setContrato_id(Long contrato_id) {
        this.contrato_id = contrato_id;
    }

    public String getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        

}