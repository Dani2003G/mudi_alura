package br.com.alura.mvc.mudi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    private BigDecimal valorNegociado;

    private LocalDate dataEntrega;

    @Column(length = 1000)
    private String urlProduto;

    @Column(length = 1000)
    private String urlImagem;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
