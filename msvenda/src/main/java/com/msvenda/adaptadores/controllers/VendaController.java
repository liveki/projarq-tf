package com.msvenda.adaptadores.controllers;

import java.util.List;

import com.msvenda.adaptadores.controllers.DTO.SubtotalDTO;
import com.msvenda.aplicacao.casosDeUso.CadastraVendaUC;
import com.msvenda.aplicacao.casosDeUso.ConsultaVendasUC;
import com.msvenda.negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msvendas")
public class VendaController {
  private ConsultaVendasUC consultaVendas;
  private CadastraVendaUC cadastraVenda;

  @Autowired
  public VendaController(ConsultaVendasUC consultaVendas, CadastraVendaUC cadastraVenda) {
    this.consultaVendas = consultaVendas;
    this.cadastraVenda = cadastraVenda;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> vendasEfetuadas() {
    System.out.print("cheguei no historico do microserviço");
    return consultaVendas.executar();
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public Boolean confirmaVenda(@RequestBody final Venda venda) {
    System.out.print("cheguei no microserviço de vendas");
    return cadastraVenda.executar(venda);
  }
}
