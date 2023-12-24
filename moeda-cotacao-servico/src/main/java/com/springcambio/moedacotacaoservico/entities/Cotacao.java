package com.springcambio.moedacotacaoservico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Cotacao {
    @Id
    private Long id;
    private String de;
    private String para;
    private BigDecimal cotacao;
    private String ambiente;

    public Cotacao(Long id, String de, String para, BigDecimal cotacao) {
        this.id = id;
        this.de = de;
        this.para = para;
        this.cotacao = cotacao;
    }

    public Cotacao() {
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

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
}
