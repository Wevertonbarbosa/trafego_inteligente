package br.com.fiap.trafego_inteligente.dto;

import jakarta.validation.constraints.NotBlank;

public record ViagemGravarDto(
        Long id,
        @NotBlank(message = "Campo Veiculo é Obrigatório!")
        String veiculo,
        @NotBlank(message = " Campo tamanho ônibus é Obrigatório!")
        String tamanho_onibus,
        @NotBlank(message = "Campo placa  é Obrigatório!")
        String placa,
        @NotBlank(message = "Campo registro ônibus é Obrigatório!")
        String registroOnibus,
        @NotBlank(message = "Campo hr_saida é Obrigatório!")
        String hr_saida,
        @NotBlank(message = "Campo hr_chegar é Obrigatório!")
        String hr_chegar,
        @NotBlank(message = "Campo rota_saida é Obrigatório!")
        String rota_saida,
        @NotBlank(message = "Campo rota_chegada é Obrigatório!")
        String rota_chegada

) {
}
