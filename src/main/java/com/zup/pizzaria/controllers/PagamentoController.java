package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.services.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;


    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> realizarPagamento(@RequestBody PagamentoDTO pagamento) {
        PagamentoDTO pagamentoDTO = pagamentoService.realizarPagamento(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoDTO);
    }

}
