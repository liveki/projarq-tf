package com.msvenda;

import com.msvenda.negocio.entidades.Venda;
import com.msvenda.negocio.servicos.ServicoVenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
  @Autowired
  private ServicoVenda servicoVenda;

  public void receiveMessage(Venda novaVenda) {
    servicoVenda.cadastraVenda(novaVenda);
  }
}
