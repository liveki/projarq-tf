package com.msvenda.adaptadores.repositorios.interfaces;

import java.util.List;

import com.msvenda.negocio.entidades.Produto;
import org.springframework.data.repository.CrudRepository;

public interface IProdutoRepositoryJPA extends CrudRepository<Produto, Integer> {
  List<Produto> findAll();
}