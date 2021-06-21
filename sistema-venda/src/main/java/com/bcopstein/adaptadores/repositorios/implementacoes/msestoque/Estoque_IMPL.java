package com.bcopstein.adaptadores.repositorios.implementacoes.msestoque;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bcopstein.adaptadores.repositorios.interfaces.msestoque.IEstoqueRepositoryMS;
import com.bcopstein.negocio.entidades.ItemEstoque;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class Estoque_IMPL implements IEstoqueRepositoryMS {

  final String BASE_URL = "http://host.docker.internal:8080/msestoque/";

  @Override
  public ItemEstoque getProduto(int codigo) {
    WebClient client;
    client = WebClient.builder().baseUrl(BASE_URL + "produto/" + codigo).build();
    Mono<ItemEstoque> response = client.get().retrieve().bodyToMono(ItemEstoque.class);
    return response.block();
  }

  @Override
  public void atualizaProduto(ItemEstoque itemEstoque) {
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<ItemEstoque> request = new HttpEntity<>(itemEstoque);
    restTemplate.exchange(BASE_URL + "produto", HttpMethod.PATCH, request, Void.class);
  }

  @Override
  public Boolean autorizaProduto(int codProduto, int qtdade) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");

    Map<String, String> params = new HashMap<String, String>();
    params.put("codProduto", Integer.toString(codProduto));
    params.put("qtdade", Integer.toString(qtdade));

    HttpEntity entity = new HttpEntity(headers);
    HttpEntity<Boolean> response = restTemplate.exchange(BASE_URL + "autorizacao", HttpMethod.GET, entity,
        Boolean.class, params);
    return response.getBody();
  }

  @Override
  public List<ItemEstoque> todos() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<ItemEstoque[]> response = restTemplate.getForEntity(BASE_URL + "todos", ItemEstoque[].class);
    return Arrays.asList(response.getBody());
  }

}
