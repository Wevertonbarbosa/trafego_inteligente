package br.com.fiap.trafego_inteligente.dto;

import br.com.fiap.trafego_inteligente.model.Viagem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ViagemExibicaoDto(
        Long id,
        @NotBlank(message = "Tamanho do Ônibus é obrigatório!")
        String tamanho_onibus,

        @NotBlank(message = "Registro do Ônibus é obrigatório!")
        String registroOnibus,

        @NotBlank(message = "Horário da saída é obrigatório!")
        @Size(max = 7, message = "Horário de saída é apenas 7 caracteres")
        String hr_saida,

        @NotBlank(message = "Horário de chegar é obrigatório!")
        @Size(max = 7, message = "Horário de chegar é apenas 7 caracteres")
        String hr_chegar,

        @NotBlank(message = "Informar a rota de saída é obrigatório!")
        String rota_saida,

        @NotBlank(message = "Informar a rota de chegada é obrigatório!")
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
