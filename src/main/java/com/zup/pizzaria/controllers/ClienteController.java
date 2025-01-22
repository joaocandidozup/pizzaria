package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.responses.ApiResponse;
import com.zup.pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteDTO>> cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCriado = clienteService.cadastrarCliente(clienteDTO);

        ApiResponse<ClienteDTO> response = new ApiResponse<>(
                "success",
                "Cliente cadastrado com sucesso!",
                clienteCriado
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
