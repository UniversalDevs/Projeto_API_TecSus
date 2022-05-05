package com.spring.TecSUS.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="concessionarias")
public class Concessionaria {
    

    //verificar se campo ID é necessário, já que o CNPJ já é um dado único. 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conc_id;

    private String conc_cnpj;
    
    private String conc_IE; //Inscrição Estatudal
    
    private String conc_inscricao_unica_reg;     //Inscrição unica de registro.  mudar nome da variavel. 
    
    private String conc_processo;

    private String conc_nome; 

    private String conc_end;  //endereço

    private String conc_cxpst; //caixa postal. 

    private String conc_cep;

    private String conc_cidade;

    private String conc_estado;  

    @OneToMany(mappedBy = "concessionaria")
    private Set<Contrato> contratos;

    public Long getConc_id() {
        return conc_id;
    }

    public void setConc_id(Long conc_id) {
        this.conc_id = conc_id;
    }

    public String getConc_cnpj() {
        return conc_cnpj;
    }

    public void setConc_cnpj(String conc_cnpj) {
        this.conc_cnpj = conc_cnpj;
    }

    public String getConc_IE() {
        return conc_IE;
    }

    public void setConc_IE(String conc_IE) {
        this.conc_IE = conc_IE;
    }

    public String getConc_inscricao_unica_reg() {
        return conc_inscricao_unica_reg;
    }

    public void setConc_inscricao_unica_reg(String conc_inscricao_unica_reg) {
        this.conc_inscricao_unica_reg = conc_inscricao_unica_reg;
    }

    public String getConc_processo() {
        return conc_processo;
    }

    public void setConc_processo(String conc_processo) {
        this.conc_processo = conc_processo;
    }

    public String getConc_nome() {
        return conc_nome;
    }

    public void setConc_nome(String conc_nome) {
        this.conc_nome = conc_nome;
    }

    public String getConc_end() {
        return conc_end;
    }

    public void setConc_end(String conc_end) {
        this.conc_end = conc_end;
    }

    public String getConc_cxpst() {
        return conc_cxpst;
    }

    public void setConc_cxpst(String conc_cxpst) {
        this.conc_cxpst = conc_cxpst;
    }

    public String getConc_cep() {
        return conc_cep;
    }

    public void setConc_cep(String conc_cep) {
        this.conc_cep = conc_cep;
    }

    public String getConc_cidade() {
        return conc_cidade;
    }

    public void setConc_cidade(String conc_cidade) {
        this.conc_cidade = conc_cidade;
    }

    public String getConc_estado() {
        return conc_estado;
    }

    public void setConc_estado(String conc_estado) {
        this.conc_estado = conc_estado;
    }

    public Set<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(Set<Contrato> contratos) {
        this.contratos = contratos;
    }

    

}
