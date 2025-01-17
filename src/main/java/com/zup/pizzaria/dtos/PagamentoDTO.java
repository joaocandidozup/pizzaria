package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.FormaPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PagamentoDTO {
    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;

    @NotNull(message = "A forma de pagamento não pode ser nula.")
    private FormaPagamento formaPagamento;

    @NotNull(message = "O valor do pagamento não pode ser nulo.")
    @Positive(message = "O valor do pagamento deve ser maior que zero.")
    private Double valorPago;

    public PagamentoDTO(Long pedidoId, FormaPagamento formaPagamento, Double valorPago) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
}
