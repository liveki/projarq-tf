package com.msvenda.negocio.servicos;

import java.util.List;

import com.msvenda.negocio.entidades.Produto;
import com.msvenda.negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {
  private IProdutoRepository produtoRepository;

  @Autowired
  public ServicoProduto(IProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public List<Produto> todos() {
    return produtoRepository.todos();
  }
}
