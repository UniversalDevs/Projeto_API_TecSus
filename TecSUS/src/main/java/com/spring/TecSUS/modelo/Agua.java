package com.spring.TecSUS.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aguas")
public class Agua {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long agua_id;

    private String numero_documento;
    private String data_emissao;
    private String hidrometro;
    private String lacre;

    //Azul
    private String economia;
    private String tipo_ligacao;
    private String data_apresentacao;
    private String proxima_leitura;
    private String tipo_mercado;
    private String condicao_leitura;

    //Mini relatorio
    private String leitura_anterior;
    private String leitura_atual;
    private Float consumo;
    private String periodo;

    //Historico de Consumo
    private Float media;
    private Float agua;
    private Float esgoto;
    private Float taxa;
    private Float total;
    private String data_vencimento;

    @ManyToOne
    @JoinColumn(name="contrato_id", nullable = false)
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name =  "cli_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name =  "conc_id", nullable = false)
    private Concessionaria concessionaria;

    @ManyToOne
    @JoinColumn(name="codigo_identificador", nullable = false)
    private Instalacao instalacao;

    public Long getAgua_id() {
        return agua_id;
    }

    public void setAgua_id(Long agua_id) {
        this.agua_id = agua_id;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(String hidrometro) {
        this.hidrometro = hidrometro;
    }

    public String getLacre() {
        return lacre;
    }

    public void setLacre(String lacre) {
        this.lacre = lacre;
    }

    public String getEconomia() {
        return economia;
    }

    public void setEconomia(String economia) {
        this.economia = economia;
    }

    public String getTipo_ligacao() {
        return tipo_ligacao;
    }

    public void setTipo_ligacao(String tipo_ligacao) {
        this.tipo_ligacao = tipo_ligacao;
    }

    public String getData_apresentacao() {
        return data_apresentacao;
    }

    public void setData_apresentacao(String data_apresentacao) {
        this.data_apresentacao = data_apresentacao;
    }

    public String getProxima_leitura() {
        return proxima_leitura;
    }

    public void setProxima_leitura(String proxima_leitura) {
        this.proxima_leitura = proxima_leitura;
    }

    public String getTipo_mercado() {
        return tipo_mercado;
    }

    public void setTipo_mercado(String tipo_mercado) {
        this.tipo_mercado = tipo_mercado;
    }

    public String getCondicao_leitura() {
        return condicao_leitura;
    }

    public void setCondicao_leitura(String condicao_leitura) {
        this.condicao_leitura = condicao_leitura;
    }

    public String getLeitura_anterior() {
        return leitura_anterior;
    }

    public void setLeitura_anterior(String leitura_anterior) {
        this.leitura_anterior = leitura_anterior;
    }

    public String getLeitura_atual() {
        return leitura_atual;
    }

    public void setLeitura_atual(String leitura_atual) {
        this.leitura_atual = leitura_atual;
    }

    public Float getConsumo() {
        return consumo;
    }

    public void setConsumo(Float consumo) {
        this.consumo = consumo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public Float getAgua() {
        return agua;
    }

    public void setAgua(Float agua) {
        this.agua = agua;
    }

    public Float getEsgoto() {
        return esgoto;
    }

    public void setEsgoto(Float esgoto) {
        this.esgoto = esgoto;
    }

    public Float getTaxa() {
        return taxa;
    }

    public void setTaxa(Float taxa) {
        this.taxa = taxa;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
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

    


}
