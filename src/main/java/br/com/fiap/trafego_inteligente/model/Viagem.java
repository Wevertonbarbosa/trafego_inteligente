package br.com.fiap.trafego_inteligente.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_trafego")
public class Viagem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_TRAFEGO_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_TRAFEGO_SEQ",
            sequenceName = "TBL_TRAFEGO_SEQ",
            allocationSize = 1
    )
    private Long id;

    private String veiculo;
    private String tamanho_onibus;
    private String placa;
    private String registroOnibus;
    @Column(name = "HORA_SAIDA")
    private String hr_saida;
    @Column(name = "HORA_CHEGAR")
    private String hr_chegar;
    private String rota_saida;
    private String rota_chegada;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viagem viagem = (Viagem) o;
        return Objects.equals(id, viagem.id) && Objects.equals(veiculo, viagem.veiculo) && Objects.equals(tamanho_onibus, viagem.tamanho_onibus) && Objects.equals(placa, viagem.placa) && Objects.equals(registroOnibus, viagem.registroOnibus) && Objects.equals(hr_saida, viagem.hr_saida) && Objects.equals(hr_chegar, viagem.hr_chegar) && Objects.equals(rota_saida, viagem.rota_saida) && Objects.equals(rota_chegada, viagem.rota_chegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, veiculo, tamanho_onibus, placa, registroOnibus, hr_saida, hr_chegar, rota_saida, rota_chegada);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getTamanho_onibus() {
        return tamanho_onibus;
    }

    public void setTamanho_onibus(String tamanho_onibus) {
        this.tamanho_onibus = tamanho_onibus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRegistroOnibus() {
        return registroOnibus;
    }

    public void setRegistroOnibus(String registroOnibus) {
        this.registroOnibus = registroOnibus;
    }

    public String getHr_saida() {
        return hr_saida;
    }

    public void setHr_saida(String hr_saida) {
        this.hr_saida = hr_saida;
    }

    public String getHr_chegar() {
        return hr_chegar;
    }

    public void setHr_chegar(String hr_chegar) {
        this.hr_chegar = hr_chegar;
    }

    public String getRota_saida() {
        return rota_saida;
    }

    public void setRota_saida(String rota_saida) {
        this.rota_saida = rota_saida;
    }

    public String getRota_chegada() {
        return rota_chegada;
    }

    public void setRota_chegada(String rota_chegada) {
        this.rota_chegada = rota_chegada;
    }
}
