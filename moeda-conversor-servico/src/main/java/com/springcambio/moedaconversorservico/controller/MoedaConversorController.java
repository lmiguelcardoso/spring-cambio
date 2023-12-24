package com.springcambio.moedaconversorservico.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcambio.moedaconversorservico.proxy.MoedaCotacaoProxy;
import com.springcambio.moedaconversorservico.entities.MoedaConversao;

@RestController
public class MoedaConversorController {

        @Autowired
        private MoedaCotacaoProxy proxy;

        @GetMapping("moeda-conversao/de/{de}/para/{para}/quantidade/{quantidade}")
        public MoedaConversao getConversao(
                        @PathVariable String de,
                        @PathVariable String para,
                        @PathVariable BigDecimal quantidade) {
                HashMap uriVariables = new HashMap<>();
                uriVariables.put("de", de);
                uriVariables.put("para", para);

                // VERBOSE IMP
                ResponseEntity<MoedaConversao> responseEntity = new RestTemplate()
                                .getForEntity(
                                                "http://localhost:8000/moeda-cotacao/de/{de}/para/{para}",
                                                MoedaConversao.class,
                                                uriVariables);

                MoedaConversao moedaConversao = responseEntity.getBody();

                return new MoedaConversao(moedaConversao.getId(), de, para, quantidade, moedaConversao.getCotacao(),
                                quantidade.multiply(moedaConversao.getCotacao()), moedaConversao.getAmbiente());
        }

        @GetMapping("moeda-conversao-feign/de/{de}/para/{para}/quantidade/{quantidade}")
        public MoedaConversao getConversaoFeign(@PathVariable String de,
                        @PathVariable String para,
                        @PathVariable BigDecimal quantidade) {
                MoedaConversao moedaConversao = proxy.getCotacao(de, para);

                return new MoedaConversao(moedaConversao.getId(), de, para, quantidade, moedaConversao.getCotacao(),
                                quantidade.multiply(moedaConversao.getCotacao()), moedaConversao.getAmbiente());
        }
}
