package com.msvenda.negocio.servicos;

import java.time.LocalTime;
import java.util.List;

import com.msvenda.aplicacao.servicos.ICalculoImposto;
import com.msvenda.aplicacao.servicos.IRestricaoHorarioVenda;
import com.msvenda.aplicacao.servicos.RestricaoVendaFactory;
import com.msvenda.negocio.entidades.ItemCarrinho;
import com.msvenda.negocio.entidades.ItemEstoque;
import com.msvenda.negocio.entidades.Venda;
import com.msvenda.negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoVenda {
  private IVendaRepository vendaRepository;
  private ICalculoImposto calculoImposto;
  private ServicoEstoque servicoEstoque;

  @Autowired
  public ServicoVenda(IVendaRepository vendaRepository, ICalculoImposto calculoImposto, ServicoEstoque servicoEstoque) {
    this.vendaRepository = vendaRepository;
    this.calculoImposto = calculoImposto;
    this.servicoEstoque = servicoEstoque;
  }

  public List<Venda> todos() {
    return vendaRepository.todos();
  }

  public Integer[] consultaVenda(List<ItemCarrinho> itens) {
    Integer subtotal = 0;
    Integer imposto = 0;

    for (final ItemCarrinho prod : itens) {
      if (prod != null) {
        subtotal += (int) prod.getPrecoUnitario() * prod.getQuantidade();
      } else {
        throw new IllegalArgumentException("Codigo invalido");
      }
    }

    imposto = calculoImposto.calculaImposto(itens);

    final Integer[] resp = new Integer[3];

    resp[0] = subtotal;
    resp[1] = imposto;
    resp[2] = subtotal + imposto;

    return resp;
  }

  public boolean cadastraVenda(Venda novaVenda) {
    this.vendaRepository.cadastra(novaVenda);

    return true;
  }
}