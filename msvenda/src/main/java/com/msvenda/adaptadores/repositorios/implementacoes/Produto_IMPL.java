package com.msvenda.adaptadores.repositorios.implementacoes;

import java.util.List;

import com.msvenda.adaptadores.repositorios.interfaces.IProdutoRepositoryJPA;
import com.msvenda.negocio.entidades.Produto;
import com.msvenda.negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Produto_IMPL implements IProdutoRepository {

  private IProdutoRepositoryJPA produtoRepository;

  @Autowired
  public Produto_IMPL(IProdutoRepositoryJPA produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  @Override
  public List<Produto> todos() {
    return produtoRepository.findAll();
  }

}
