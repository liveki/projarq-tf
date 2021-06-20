package com.msestoque.adaptadores.controllers;

import java.util.List;

import com.msestoque.aplicacao.casosDeUso.AtualizaProdutoEstoqueUC;
import com.msestoque.aplicacao.casosDeUso.ObterProdutoUC;
import com.msestoque.aplicacao.casosDeUso.ProdutosDisponiveisUC;
import com.msestoque.aplicacao.casosDeUso.VerificaEstoqueProdutoUC;
import com.msestoque.negocio.entidades.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
  private AtualizaProdutoEstoqueUC atualizaEstoque;
  private VerificaEstoqueProdutoUC verificaEstoqueProduto;
  private ProdutosDisponiveisUC produtosDisponiveis;
  private ObterProdutoUC obterProduto;

 
  @Autowired
  public EstoqueController(AtualizaProdutoEstoqueUC atualizaEstoque, VerificaEstoqueProdutoUC verificaEstoqueProduto, ProdutosDisponiveisUC produtosDisponiveis, ObterProdutoUC obterProduto) {
    this.atualizaEstoque = atualizaEstoque;
    this.verificaEstoqueProduto = verificaEstoqueProduto;
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

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    return verificaEstoqueProduto.executar(codProd, qtdade);
  }

  @GetMapping("/todos")
  @CrossOrigin(origins = "*")
  public List<ItemEstoque> todos() {
    return produtosDisponiveis.executar();
  }

}

