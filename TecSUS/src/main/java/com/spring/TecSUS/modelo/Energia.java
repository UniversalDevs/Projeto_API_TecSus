package com.spring.TecSUS.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

@Entity
@Table(name = "energias")
public class Energia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long energia_id;
    private String ano;
    private String mes;
    private Float valor_total_a_pagar;
    private Integer consumo_mes_kwh;
    private String data_de_vencimento;
    private String mes_referencia;
    //Bandeiras tarifarias
    private String bandeira_tarifaria;
    private String data_inicio;
    private String data_termino;
    //Periodo de Faturamento
    private String data_emissão;
    private String leitura_anterior;
    private String leitura_atual;
    private String dias_faturamento;
    private String proxima_leitura;
    //Descricao de consumo
    private Float valor_leitura_anterior;
    private Float valor_leitura_atual;
    private Float const_mult;
    private Float qtde_kwh_mes;
    //Detalhes de Faturamento
    private Float tusd_qtd_kwh;
    private Float tusd_tarifa_aplicada;
    private Float tusd_valor_fornec;
    private Float tusd_tarifa_imposto;
    private Float tusd_bcalc_icms;
    private Float tusd_bcalc_piscofins;
    //Itens financeiros
    private Float contribuicao_municipal_valor;
    //Tributos
    private Float pis_bcalc;
    private Float cofins_bcalc;
    private Float icms_bcalc;
    private Float pis_aliqota;
    private Float cofins_aliqota;
    private Float icms_aliqota;
    private Float pis_valor;
    private Float cofins_valor;
    private Float icms_valor;
    

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

    public Long getEnergia_id() {
        return energia_id;
    }

    public void setEnergia_id(Long energia_id) {
        this.energia_id = energia_id;
    }

    public Float getValor_total_a_pagar() {
        return valor_total_a_pagar;
    }

    public void setValor_total_a_pagar(Float valor_total_a_pagar) {
        this.valor_total_a_pagar = valor_total_a_pagar;
    }

    public Integer getConsumo_mes_kwh() {
        return consumo_mes_kwh;
    }

    public void setConsumo_mes_kwh(Integer consumo_mes_kwh) {
        this.consumo_mes_kwh = consumo_mes_kwh;
    }

    public String getData_de_vencimento() {
        return data_de_vencimento;
    }

    public void setData_de_vencimento(String data_de_vencimento) {
        this.data_de_vencimento = data_de_vencimento;
    }

    public String getMes_referencia() {
        return mes_referencia;
    }

    public void setMes_referencia(String mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public String getBandeira_tarifaria() {
        return bandeira_tarifaria;
    }

    public void setBandeira_tarifaria(String bandeira_tarifaria) {
        this.bandeira_tarifaria = bandeira_tarifaria;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

    public String getData_emissão() {
        return data_emissão;
    }

    public void setData_emissão(String data_emissão) {
        this.data_emissão = data_emissão;
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

    public String getDias_faturamento() {
        return dias_faturamento;
    }

    public void setDias_faturamento(String dias_faturamento) {
        this.dias_faturamento = dias_faturamento;
    }

    public String getProxima_leitura() {
        return proxima_leitura;
    }

    public void setProxima_leitura(String proxima_leitura) {
        this.proxima_leitura = proxima_leitura;
    }

    public Float getValor_leitura_anterior() {
        return valor_leitura_anterior;
    }

    public void setValor_leitura_anterior(Float valor_leitura_anterior) {
        this.valor_leitura_anterior = valor_leitura_anterior;
    }

    public Float getValor_leitura_atual() {
        return valor_leitura_atual;
    }

    public void setValor_leitura_atual(Float valor_leitura_atual) {
        this.valor_leitura_atual = valor_leitura_atual;
    }

    public Float getConst_mult() {
        return const_mult;
    }

    public void setConst_mult(Float const_mult) {
        this.const_mult = const_mult;
    }

    public Float getQtde_kwh_mes() {
        return qtde_kwh_mes;
    }

    public void setQtde_kwh_mes(Float qtde_kwh_mes) {
        this.qtde_kwh_mes = qtde_kwh_mes;
    }

    public Float getTusd_qtd_kwh() {
        return tusd_qtd_kwh;
    }

    public void setTusd_qtd_kwh(Float tusd_qtd_kwh) {
        this.tusd_qtd_kwh = tusd_qtd_kwh;
    }

    public Float getTusd_tarifa_aplicada() {
        return tusd_tarifa_aplicada;
    }

    public void setTusd_tarifa_aplicada(Float tusd_tarifa_aplicada) {
        this.tusd_tarifa_aplicada = tusd_tarifa_aplicada;
    }

    public Float getTusd_valor_fornec() {
        return tusd_valor_fornec;
    }

    public void setTusd_valor_fornec(Float tusd_valor_fornec) {
        this.tusd_valor_fornec = tusd_valor_fornec;
    }

    public Float getTusd_tarifa_imposto() {
        return tusd_tarifa_imposto;
    }

    public void setTusd_tarifa_imposto(Float tusd_tarifa_imposto) {
        this.tusd_tarifa_imposto = tusd_tarifa_imposto;
    }

    public Float getTusd_bcalc_icms() {
        return tusd_bcalc_icms;
    }

    public void setTusd_bcalc_icms(Float tusd_bcalc_icms) {
        this.tusd_bcalc_icms = tusd_bcalc_icms;
    }

    public Float getTusd_bcalc_piscofins() {
        return tusd_bcalc_piscofins;
    }

    public void setTusd_bcalc_piscofins(Float tusd_bcalc_piscofins) {
        this.tusd_bcalc_piscofins = tusd_bcalc_piscofins;
    }

    public Float getContribuicao_municipal_valor() {
        return contribuicao_municipal_valor;
    }

    public void setContribuicao_municipal_valor(Float contribuicao_municipal_valor) {
        this.contribuicao_municipal_valor = contribuicao_municipal_valor;
    }

    public Float getPis_bcalc() {
        return pis_bcalc;
    }

    public void setPis_bcalc(Float pis_bcalc) {
        this.pis_bcalc = pis_bcalc;
    }

    public Float getCofins_bcalc() {
        return cofins_bcalc;
    }

    public void setCofins_bcalc(Float cofins_bcalc) {
        this.cofins_bcalc = cofins_bcalc;
    }

    public Float getPis_aliqota() {
        return pis_aliqota;
    }

    public void setPis_aliqota(Float pis_aliqota) {
        this.pis_aliqota = pis_aliqota;
    }

    public Float getCofins_aliqota() {
        return cofins_aliqota;
    }

    public void setCofins_aliqota(Float cofins_aliqota) {
        this.cofins_aliqota = cofins_aliqota;
    }

    public Float getPis_valor() {
        return pis_valor;
    }

    public void setPis_valor(Float pis_valor) {
        this.pis_valor = pis_valor;
    }

    public Float getCofins_valor() {
        return cofins_valor;
    }

    public void setCofins_valor(Float cofins_valor) {
        this.cofins_valor = cofins_valor;
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

    public Float getIcms_bcalc() {
        return icms_bcalc;
    }

    public void setIcms_bcalc(Float icms_bcalc) {
        this.icms_bcalc = icms_bcalc;
    }

    public Float getIcms_aliqota() {
        return icms_aliqota;
    }

    public void setIcms_aliqota(Float icms_aliqota) {
        this.icms_aliqota = icms_aliqota;
    }

    public Float getIcms_valor() {
        return icms_valor;
    }

    public void setIcms_valor(Float icms_valor) {
        this.icms_valor = icms_valor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    
    
}
