package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
        clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Pedido pedido = PedidoDTO.converterDtoParaEntidade(pedidoDTO);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return PedidoDTO.converterEntidadeParaDto(pedidoSalvo);
    }
}
