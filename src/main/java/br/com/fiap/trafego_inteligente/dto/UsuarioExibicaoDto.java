package br.com.fiap.trafego_inteligente.dto;

import br.com.fiap.trafego_inteligente.model.Usuario;
import br.com.fiap.trafego_inteligente.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role
) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }
}
