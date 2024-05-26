package br.com.fiap.trafego_inteligente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "Email do Usuário é obrigatório!")
        @Email(message = "Email com formato inválido.")
        String email,
        @NotBlank(message = "Senha é obrigatório!")
        @Size(min = 6, max = 20, message = "Senha precisa ter entre 6 a 20 caracteres!")
        String senha

) {

}
