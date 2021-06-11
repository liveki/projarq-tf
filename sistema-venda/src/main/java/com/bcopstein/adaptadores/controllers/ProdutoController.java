package com.bcopstein.adaptadores.controllers;

import java.util.List;

import com.bcopstein.aplicacao.casosDeUso.ConsultaProdutosUC;
import com.bcopstein.negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class ProdutoController {
  private ConsultaProdutosUC consultaProdutos;

  @Autowired
  public ProdutoController(ConsultaProdutosUC consultaProdutos) {
    this.consultaProdutos = consultaProdutos;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return consultaProdutos.executar();
  }
}
