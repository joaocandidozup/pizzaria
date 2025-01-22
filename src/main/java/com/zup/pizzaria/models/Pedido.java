package com.zup.pizzaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Long clienteId;
    private Double valorTotal;

    public Pedido() {
    }

    public Pedido(Long clienteId, String descricao,Double valorTotal) {
        this.clienteId = clienteId;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public Long getId() {
        return id;
    }
}
