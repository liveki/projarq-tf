package com.bcopstein.adaptadores.repositorios.interfaces.msestoque;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

public interface IEstoqueRepositoryMS extends IEstoqueRepository {
    
    ItemEstoque getProduto(int codigo);

    Boolean autorizaProduto(int codProduto, int qtdade);

    List<ItemEstoque> todos();

   
}
