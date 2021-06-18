package com.msestoque.adaptadores.controllers;

import com.msestoque.aplicacao.casosDeUso.AtualizaProdutoEstoqueUC;
import com.msestoque.negocio.entidades.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
  private AtualizaProdutoEstoqueUC atualizaEstoque;

 
  @Autowired
  public EstoqueController(AtualizaProdutoEstoqueUC atualizaEstoque) {
    this.atualizaEstoque = atualizaEstoque;
}

  @PatchMapping("/produto")
  @CrossOrigin(origins = "*")
  public void atualizaProduto(@RequestBody final ItemEstoque itemEstoque) {
  atualizaEstoque.executar(itemEstoque);

  }
  
}

