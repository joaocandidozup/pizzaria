package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClienteDTO {
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio ou nulo.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{8,}", message = "O telefone deve conter apenas números e ter no mínimo 8 dígitos.")
    private String telefone;

    public ClienteDTO(Long id,String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
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
    public Long getId() {
        return id;
    }

    public static Cliente converterDtoParaEntidade(ClienteDTO dto) {
        return new Cliente(dto.getNome(), dto.getEmail(), dto.getTelefone());
    }

    public static ClienteDTO converterEntidadeParaDto(Cliente cliente) {
        return new ClienteDTO(cliente.getId(),cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }
}
