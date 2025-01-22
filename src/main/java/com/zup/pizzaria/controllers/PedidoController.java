package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.responses.ApiResponse;
import com.zup.pizzaria.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PedidoDTO>> criarPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoCriado = pedidoService.criarPedido(pedidoDTO);

        ApiResponse<PedidoDTO> response = new ApiResponse<>(
             "success",
             "pedido cadastrado com sucesso!" ,
             pedidoCriado
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
