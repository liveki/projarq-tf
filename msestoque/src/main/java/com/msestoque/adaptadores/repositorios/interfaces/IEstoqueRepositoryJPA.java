package com.msestoque.adaptadores.repositorios.interfaces;

import com.msestoque.negocio.entidades.ItemEstoque;

import org.springframework.data.repository.CrudRepository;

public interface IEstoqueRepositoryJPA extends CrudRepository<ItemEstoque, Integer> {
  
}
