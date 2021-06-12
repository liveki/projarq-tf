package com.msvenda.negocio.repositorios;

import com.msvenda.negocio.entidades.ItemEstoque;

public interface IEstoqueRepository {

  ItemEstoque getProduto(int codigo);

  void atualizaProduto(ItemEstoque itemEstoque);

}
