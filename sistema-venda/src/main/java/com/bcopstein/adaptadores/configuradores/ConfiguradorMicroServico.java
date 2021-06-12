package com.bcopstein.adaptadores.configuradores;

import com.bcopstein.adaptadores.repositorios.implementacoes.VendaJpa_IMPL;
import com.bcopstein.adaptadores.repositorios.implementacoes.msvendas.Venda_IMPL;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorMicroServico {
  @Bean
  @ConditionalOnProperty(name = "vendas.ms", havingValue = "comMS", matchIfMissing = true)
  public IVendaRepository opcaoMicroServico() {
    return new Venda_IMPL();
  }

  @Bean
  @ConditionalOnProperty(name = "vendas.ms", havingValue = "semMS")
  public IVendaRepository opcaoSemMS() {
    return new VendaJpa_IMPL();
  }
}
