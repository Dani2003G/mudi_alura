package br.com.alura.mvc.mudi.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Pedido {

    private String nomeProduto;

    private BigDecimal valorNegociado;

    private LocalDate dataEntrega;

    private String urlProduto;

    private String urlImagem;

    private String descricao;

}
