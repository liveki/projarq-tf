package com.bcopstein.adaptadores.repositorios.implementacoes.msvendas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.stereotype.Component;

public class Venda_IMPL implements IVendaRepository {
  HttpClient client;
  HttpRequest request;
  final String BASE_URL = "http://host.docker.internal:8080/msvendas/";

  public Venda_IMPL() {
    client = HttpClient.newHttpClient();
  }

  @Override
  public void cadastra(Venda venda) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Venda> todos() {
    request = HttpRequest.newBuilder().GET().uri(URI.create(BASE_URL + "historico")).build();

    HttpResponse<List<Venda>> response = null;
    HttpResponse.BodyHandler<List<Venda>> bodyHandler = null;

    try {
      response = client.send(request, bodyHandler);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return response.body();
  }

}
