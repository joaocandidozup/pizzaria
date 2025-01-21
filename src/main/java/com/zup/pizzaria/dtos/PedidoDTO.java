package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PedidoDTO {
    @NotNull(message = "O id não pode estar em branco ou ser nulo")
    private Long clienteId;

    @NotBlank(message = "A descrição não pode estar em branco ou ser nula")
    private String descricaoPedido;

    @NotNull(message = "O valor total não pode ser nulo")
    @Positive(message = "O valor total tem que ser um inteiro positivo")
    private Double valorTotal;

    public PedidoDTO(Long clienteId, String descricaoPedido, Double valorTotal) {
        this.clienteId = clienteId;
        this.descricaoPedido = descricaoPedido;
        this.valorTotal = valorTotal;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }


    public static Pedido converterDtoParaEntidade(PedidoDTO dto){
        return new Pedido(dto.getClienteId(), dto.getDescricaoPedido(),dto.getValorTotal());
    }

    public static PedidoDTO converterEntidadeParaDto(Pedido pedido){
        return new PedidoDTO(pedido.getClienteId(), pedido.getDescricao(), pedido.getValorTotal());
    }
}
