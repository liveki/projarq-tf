package com.bcopstein.adaptadores.repositorios.implementacoes.msvendas;

import java.util.Arrays;
import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;
import com.google.gson.Gson;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class Venda_IMPL implements IVendaRepository {
  WebClient client;
  final String BASE_URL = "http://host.docker.internal:8080/msvendas/";

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  public void cadastra(Venda venda) {
    String gsonObject = new Gson().toJson(venda);
    rabbitTemplate.convertAndSend("spring-boot-exchange", "vendas.nova", gsonObject);
  }

  @Override
  public List<Venda> todos() {
    client = WebClient.builder().baseUrl(BASE_URL + "historico").build();
    Mono<Venda[]> response = client.get().retrieve().bodyToMono(Venda[].class);

    return Arrays.asList(response.block());
  }

}
