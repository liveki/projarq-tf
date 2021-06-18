package com.msestoque.adaptadores.repositorios.implementacoes;

import com.msestoque.adaptadores.repositorios.interfaces.IEstoqueRepositoryJPA;
import com.msestoque.negocio.entidades.ItemEstoque;
import com.msestoque.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Estoque_IMPL implements IEstoqueRepository {

  private IEstoqueRepositoryJPA estoqueRepository;

  @Autowired
  public Estoque_IMPL(IEstoqueRepositoryJPA estoqueRepository) {
    this.estoqueRepository = estoqueRepository;
  }

  @Override
  public void atualizaProduto(ItemEstoque itemEstoque) {
    estoqueRepository.save(itemEstoque);
  }

}
