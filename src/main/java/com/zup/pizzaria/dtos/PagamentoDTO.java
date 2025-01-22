package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.FormaPagamento;
import com.zup.pizzaria.models.Pagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class PagamentoDTO {
    private Long id;
    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;

    @NotNull(message = "A forma de pagamento não pode ser nula.")
    private FormaPagamento formaPagamento;

    @NotNull(message = "O valor do pagamento não pode ser nulo.")
    @Positive(message = "O valor do pagamento deve ser maior que zero.")
    private Double valorPago;
    private LocalDateTime dataHoraPagamento;


    public PagamentoDTO(Long id, Long pedidoId, FormaPagamento formaPagamento, Double valorPago,LocalDateTime dataHoraPagamento) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.id = id;
        this.dataHoraPagamento = LocalDateTime.now();

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

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public static Pagamento converterDtoParaEntidade(PagamentoDTO dto){
        Pagamento pagamento = new Pagamento(dto.getPedidoId(), dto.getFormaPagamento(), dto.getValorPago());
        pagamento.setDataHoraPagamento(dto.dataHoraPagamento);
        return pagamento;
    }

    public static PagamentoDTO converterEntidadeParaDto(Pagamento pagamento){
        return new PagamentoDTO(pagamento.getId(), pagamento.getPedidoId(), pagamento.getFormaPagamento(), pagamento.getValorPago(),pagamento.getDataHoraPagamento());
    }
}
