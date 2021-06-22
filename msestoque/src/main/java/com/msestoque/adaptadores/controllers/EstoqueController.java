package com.msestoque.adaptadores.controllers;

import java.util.List;

import com.msestoque.aplicacao.casosDeUso.AtualizaProdutoEstoqueUC;
import com.msestoque.aplicacao.casosDeUso.ObterProdutoUC;
import com.msestoque.aplicacao.casosDeUso.ProdutosDisponiveisUC;
import com.msestoque.negocio.entidades.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msestoque")
public class EstoqueController {
  private AtualizaProdutoEstoqueUC atualizaEstoque;
  private ProdutosDisponiveisUC produtosDisponiveis;
  private ObterProdutoUC obterProduto;

  @Autowired
  public EstoqueController(AtualizaProdutoEstoqueUC atualizaEstoque, ProdutosDisponiveisUC produtosDisponiveis,
      ObterProdutoUC obterProduto) {
    this.atualizaEstoque = atualizaEstoque;
    this.produtosDisponiveis = produtosDisponiveis;
    this.obterProduto = obterProduto;
  }

  @PatchMapping("/produto")
  @CrossOrigin(origins = "*")
  public void atualizaProduto(@RequestBody final ItemEstoque itemEstoque) {
    atualizaEstoque.executar(itemEstoque);

  }

  @GetMapping("/produto/{codProduto}")
  @CrossOrigin(origins = "*")
  public ItemEstoque getProduto(@PathVariable("codProduto") int codProduto) {
    return obterProduto.executar(codProduto);

  }

  @GetMapping("/todos")
  @CrossOrigin(origins = "*")
  public List<ItemEstoque> todos() {
    return produtosDisponiveis.executar();
  }

}
