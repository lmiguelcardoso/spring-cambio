package com.springcambio.moedaconversorservico.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcambio.moedaconversorservico.entities.MoedaConversao;

@FeignClient(name = "moeda-cotacao", url = "localhost:8000")
public interface MoedaCotacaoProxy {

    @GetMapping("/moeda-cotacao/de/{de}/para/{para}")
    public MoedaConversao getCotacao(@PathVariable String de, @PathVariable String para);
}
