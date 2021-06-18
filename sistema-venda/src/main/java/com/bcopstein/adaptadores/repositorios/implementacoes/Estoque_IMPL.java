package com.bcopstein.adaptadores.repositorios.implementacoes;

import com.bcopstein.adaptadores.repositorios.interfaces.IEstoqueRepositoryJPA;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

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
  public ItemEstoque getProduto(int codigo) {
    return estoqueRepository.findByProdutoCodigo(codigo);
  }

  @Override
  public void atualizaProduto(ItemEstoque itemEstoque) {
    estoqueRepository.save(itemEstoque);
  }

}
