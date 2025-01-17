package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }
    @Transactional
    public PagamentoDTO realizarPagamento(PagamentoDTO pagamentoDTO) {

        Pedido pedido = pedidoRepository
                .findById(pagamentoDTO.getPedidoId())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));


        if (pagamentoDTO.getValorPago() < pedido.getValorTotal()) {
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(pagamentoDTO.getPedidoId());
        pagamento.setFormaPagamento(pagamentoDTO.getFormaPagamento());
        pagamento.setValorPago(pagamentoDTO.getValorPago());
        pagamento.setDataHoraPagamento(LocalDateTime.now());


        pagamentoRepository.save(pagamento);

        return new PagamentoDTO(pagamento.getPedidoId(),pagamento.getFormaPagamento(),pagamento.getValorPago());
    }
}
