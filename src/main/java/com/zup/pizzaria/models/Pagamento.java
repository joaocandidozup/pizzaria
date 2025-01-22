package com.zup.pizzaria.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private Double valorPago;
    private LocalDateTime dataHoraPagamento;

    public Pagamento() {

    }

    public Pagamento(Long pedidoId, FormaPagamento formaPagamento, Double valorPago) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }
}
