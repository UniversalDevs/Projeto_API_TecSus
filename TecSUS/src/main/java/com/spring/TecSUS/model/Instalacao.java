package com.spring.TecSUS.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Instalacao implements Serializable{

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_identificador;

    public Long getCodigo_identificador() {
        return codigo_identificador;
    }

    public void setCodigo_identificador(Long codigo_identificador) {
        this.codigo_identificador = codigo_identificador;
    }

    // Dados Tabela Instalação
    @NotBlank
    private String grupo_subgrupo;
    @NotBlank
    private String tipo_fornecimento;
    @NotBlank
    private String classe_subclasse;
    @NotBlank
    private String codigo_fiscal_operacao;
    @NotBlank
    private String modalidade_tarifaria;    
    @NotBlank
    private String roteiro_leitura;
    @NotBlank
    private String numero_medidor;
    @NotBlank
    private String tensao_nominal;


    // Getters e Setters
    public String getGrupo_subgrupo() {
        return grupo_subgrupo;
    }

    public void setGrupo_subgrupo(String grupo_subgrupo) {
        this.grupo_subgrupo = grupo_subgrupo;
    }


    public String getTipo_fornecimento() {
        return tipo_fornecimento;
    }

    public void setTipo_fornecimento(String tipo_fornecimento) {
        this.tipo_fornecimento = tipo_fornecimento;
    }

    public String getClasse_subclasse() {
        return classe_subclasse;
    }

    public void setClasse_subclasse(String classe_subclasse) {
        this.classe_subclasse = classe_subclasse;
    }

    public String getCodigo_fiscal_operacao() {
        return codigo_fiscal_operacao;
    }

    public void setCodigo_fiscal_operacao(String codigo_fiscal_operacao) {
        this.codigo_fiscal_operacao = codigo_fiscal_operacao;
    }

    public String getModalidade_tarifaria() {
        return modalidade_tarifaria;
    }

    public void setModalidade_tarifaria(String modalidade_tarifaria) {
        this.modalidade_tarifaria = modalidade_tarifaria;
    }

    public String getRoteiro_leitura() {
        return roteiro_leitura;
    }

    public void setRoteiro_leitura(String roteiro_leitura) {
        this.roteiro_leitura = roteiro_leitura;
    }

    public String getNumero_medidor() {
        return numero_medidor;
    }

    public void setNumero_medidor(String numero_medidor) {
        this.numero_medidor = numero_medidor;
    }

    public String getTensao_nominal() {
        return tensao_nominal;
    }

    public void setTensao_nominal(String tensao_nominal) {
        this.tensao_nominal = tensao_nominal;
    }


}
