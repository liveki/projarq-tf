package com.msvenda.aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.msvenda.adaptadores.controllers.DTO.SubtotalDTO;
import com.msvenda.negocio.entidades.ItemCarrinho;
import com.msvenda.negocio.entidades.Produto;
import com.msvenda.negocio.entidades.Venda;
import com.msvenda.negocio.servicos.ServicoProduto;
import com.msvenda.negocio.servicos.ServicoVenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraVendaUC {
  private ServicoVenda servicoVenda;
  private ServicoProduto servicoProduto;

  @Autowired
  public CadastraVendaUC(ServicoVenda servicoVenda, ServicoProduto servicoProduto) {
    this.servicoVenda = servicoVenda;
    this.servicoProduto = servicoProduto;
  }

  public boolean executar(Venda novaVenda) {
    return servicoVenda.cadastraVenda(novaVenda);
  }
}
