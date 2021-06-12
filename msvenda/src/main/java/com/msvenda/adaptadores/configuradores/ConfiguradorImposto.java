package com.msvenda.adaptadores.configuradores;

import com.msvenda.aplicacao.servicos.ICalculoImposto;
import com.msvenda.aplicacao.servicos.ImpostoBrasil;
import com.msvenda.aplicacao.servicos.ImpostoChile;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorImposto {

  @Bean
  @ConditionalOnProperty(name = "venda.imposto", havingValue = "brasil", matchIfMissing = true)
  public ICalculoImposto opcaoPaisBrasil() {
    return new ImpostoBrasil();
  }

  @Bean
  @ConditionalOnProperty(name = "venda.imposto", havingValue = "chile")
  public ICalculoImposto opcaoPaisChile() {
    return new ImpostoChile();
  }
}