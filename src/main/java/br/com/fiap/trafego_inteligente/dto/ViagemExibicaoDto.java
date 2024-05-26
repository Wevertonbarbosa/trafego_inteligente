package br.com.fiap.trafego_inteligente.dto;

import br.com.fiap.trafego_inteligente.model.Viagem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ViagemExibicaoDto(
        Long id,

        String tamanho_onibus,

        String registroOnibus,

        String hr_saida,

        String hr_chegar,

        String rota_saida,

        String rota_chegada
) {
    public ViagemExibicaoDto(Viagem viagem) {
        this(
                viagem.getId(),
                viagem.getTamanho_onibus(),
                viagem.getRegistroOnibus(),
                viagem.getHr_saida(),
                viagem.getRota_saida(),
                viagem.getHr_chegar(),
                viagem.getRota_chegada()

        );
    }

}
