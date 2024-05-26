package br.com.fiap.trafego_inteligente.dto;

import br.com.fiap.trafego_inteligente.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long usuarioId,
        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,
        @NotBlank(message = "O email do usuário é obrigatório!")
        @Email(message = "O email do usuário não válido!")
        String email,
        @NotBlank(message = "A senha do usuário é obrigatório!")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres!")
        String senha,

        UsuarioRole role
) {
}
