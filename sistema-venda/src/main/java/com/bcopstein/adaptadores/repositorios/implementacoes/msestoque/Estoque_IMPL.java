package com.bcopstein.adaptadores.repositorios.implementacoes.msestoque;

import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

import com.bcopstein.adaptadores.repositorios.interfaces.msestoque.IEstoqueRepositoryMS;
import com.bcopstein.negocio.entidades.ItemEstoque;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Estoque_IMPL implements IEstoqueRepositoryMS {
  RestTemplate restTemplate;

  final String BASE_URL = "http://host.docker.internal:8080/msestoque/";

  @Autowired
  private RabbitTemplate rabbitTemplate;

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
    String jsonObj = new Gson().toJson(itemEstoque);
    rabbitTemplate.convertAndSend("spring-boot-exchange", "estoque.atualiza", jsonObj);
  }

  @Override
  public List<ItemEstoque> todos() {
    ResponseEntity<ItemEstoque[]> response = restTemplate.getForEntity(BASE_URL + "todos", ItemEstoque[].class);
    return Arrays.asList(response.getBody());
  }

}
