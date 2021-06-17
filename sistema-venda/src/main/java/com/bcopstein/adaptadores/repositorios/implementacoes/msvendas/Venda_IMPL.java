package com.bcopstein.adaptadores.repositorios.implementacoes.msvendas;

import java.util.Arrays;
import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class Venda_IMPL implements IVendaRepository {
  WebClient client;
  final String BASE_URL = "http://host.docker.internal:8080/msvendas/";

  @Override
  public void cadastra(Venda venda) {
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<Venda> request = new HttpEntity<>(venda);
    restTemplate.postForEntity(BASE_URL + "confirmacao", request, Boolean.class);
  }

  @Override
  public List<Venda> todos() {
    client = WebClient.builder().baseUrl(BASE_URL + "historico").build();
    Mono<Venda[]> response = client.get().retrieve().bodyToMono(Venda[].class);

    return Arrays.asList(response.block());
  }

}
