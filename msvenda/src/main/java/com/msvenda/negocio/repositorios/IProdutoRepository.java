package com.msvenda.negocio.repositorios;

import java.util.List;

import com.msvenda.negocio.entidades.Produto;

public interface IProdutoRepository {
  List<Produto> todos();
}
