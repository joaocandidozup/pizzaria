package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClienteDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{8,}", message = "O telefone deve conter apenas números e ter no mínimo 8 dígitos.")
    private String telefone;

    public ClienteDTO(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public String getTelefone() {
        return telefone;
    }


    public static Cliente converterEntidadeParaDto(ClienteDTO dto) {
        return new Cliente(dto.getNome(), dto.getEmail(), dto.getTelefone());
    }

    public static ClienteDTO converterDtoParaEntidade(Cliente cliente) {
        return new ClienteDTO(cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }
}