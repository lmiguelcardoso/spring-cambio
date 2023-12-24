package com.springcambio.moedacotacaoservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcambio.moedacotacaoservico.entities.Cotacao;

public interface MoedaCotacaoRepository extends JpaRepository<Cotacao, Long> {
    Cotacao findByDeAndPara(final String de, final String para);

}
