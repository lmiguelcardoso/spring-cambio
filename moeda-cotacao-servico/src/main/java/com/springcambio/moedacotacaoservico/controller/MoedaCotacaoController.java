package com.springcambio.moedacotacaoservico.controller;

import com.springcambio.moedacotacaoservico.entities.Cotacao;
import com.springcambio.moedacotacaoservico.repository.MoedaCotacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MoedaCotacaoController {
    @Autowired
    private Environment ambiente;
    @Autowired
    private MoedaCotacaoRepository moedaCotacaoRepository;

    @GetMapping("moeda-cotacao/de/{de}/para/{para}")
    public Cotacao getCotacao(@PathVariable String de, @PathVariable String para) {

        Cotacao cotacao = moedaCotacaoRepository.findByDeAndPara(de.toUpperCase(), para.toUpperCase());
        if (cotacao == null) {
            throw new RuntimeException("Dado não encontrado! de: " + de + " para: " + para);
        }

        String property = ambiente.getProperty("local.server.port");
        cotacao.setAmbiente(property);
        return cotacao;
    }
}
