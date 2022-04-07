package com.spring.TecSUS.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    private String grupo_subgrupo;

    private String tipo_fornecimento;

    private String classe_subclasse;

    private String código_fiscal_operacao;

    private String modalidade_tarifaria;

    private String roteiro_leitura;

    private String número_medidor;

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

    public String getCódigo_fiscal_operacao() {
        return código_fiscal_operacao;
    }

    public void setCódigo_fiscal_operacao(String código_fiscal_operacao) {
        this.código_fiscal_operacao = código_fiscal_operacao;
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

    public String getNúmero_medidor() {
        return número_medidor;
    }

    public void setNúmero_medidor(String número_medidor) {
        this.número_medidor = número_medidor;
    }

    public String getTensao_nominal() {
        return tensao_nominal;
    }

    public void setTensao_nominal(String tensao_nominal) {
        this.tensao_nominal = tensao_nominal;
    }


}
