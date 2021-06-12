package com.msvenda.aplicacao.servicos;

import com.msvenda.negocio.entidades.Venda;

public interface IRestricaoHorarioVenda {
  public boolean vendaIsValida(Venda venda);
}
