package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        if (clienteRepository.existsByEmail(clienteDTO.getEmail())) {
            throw new IllegalArgumentException("O e-mail já está cadastrado.");
        }

        Cliente cliente = ClienteDTO.converterDtoParaEntidade(clienteDTO);
        clienteRepository.save(cliente);

        return ClienteDTO.converterEntidadeParaDto(cliente);
    }

}