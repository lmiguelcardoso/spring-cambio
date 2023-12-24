package com.springcambio.moedaconversorservico.entities;

import java.math.BigDecimal;

public class MoedaConversao {

    private Long id;
    private String de;
    private String para;
    private BigDecimal cotacao;
    private BigDecimal quantidade;
    private BigDecimal totalOperacao;
    private String ambiente;

    public MoedaConversao() {
    }

    public MoedaConversao(Long id, String de, String para, BigDecimal quantidade, BigDecimal cotacao,
            BigDecimal totalOperacao, String ambiente) {
        this.id = id;
        this.de = de;
        this.para = para;
        this.cotacao = cotacao;
        this.quantidade = quantidade;
        this.totalOperacao = totalOperacao;
        this.ambiente = ambiente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public BigDecimal getCotacao() {
        return cotacao;
    }

    public void setCotacao(BigDecimal cotacao) {
        this.cotacao = cotacao;
    }

    public BigDecimal getTotalOperacao() {
        return totalOperacao;
    }

    public void setTotalOperacao(BigDecimal totalOperacao) {
        this.totalOperacao = totalOperacao;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

}
