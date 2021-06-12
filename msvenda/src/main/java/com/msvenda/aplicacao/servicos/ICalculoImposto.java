package com.msvenda.aplicacao.servicos;

import java.util.List;

import com.msvenda.negocio.entidades.ItemCarrinho;

public interface ICalculoImposto {
  Integer calculaImposto(List<ItemCarrinho> produtos);
}
