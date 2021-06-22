package com.bcopstein.adaptadores.repositorios.implementacoes.msestoque;

import java.util.Arrays;
import java.util.List;

import com.bcopstein.adaptadores.repositorios.interfaces.msestoque.IEstoqueRepositoryMS;
import com.bcopstein.negocio.entidades.ItemEstoque;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class Estoque_IMPL implements IEstoqueRepositoryMS {
  RestTemplate restTemplate;

  final String BASE_URL = "http://host.docker.internal:8080/msestoque/";

  public Estoque_IMPL() {
    restTemplate = new RestTemplate();
  }

  @Override
  public ItemEstoque getProduto(int codigo) {
    ResponseEntity<ItemEstoque> response = restTemplate.getForEntity(BASE_URL + "produto/" + codigo, ItemEstoque.class);
    return response.getBody();
  }

  @Override
  public void atualizaProduto(ItemEstoque itemEstoque) {
    HttpClient httpClient = HttpClients.createDefault();
    HttpEntity<ItemEstoque> request = new HttpEntity<>(itemEstoque);
    restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    restTemplate.patchForObject(BASE_URL + "produto", request, Void.class);
  }

  @Override
  public List<ItemEstoque> todos() {
    ResponseEntity<ItemEstoque[]> response = restTemplate.getForEntity(BASE_URL + "todos", ItemEstoque[].class);
    return Arrays.asList(response.getBody());
  }

}
