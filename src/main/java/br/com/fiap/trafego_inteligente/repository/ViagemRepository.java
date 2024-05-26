package br.com.fiap.trafego_inteligente.repository;

import br.com.fiap.trafego_inteligente.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    //    Buscar por Id Viagem
    public Optional<Viagem> findById(Long id);

    //    Buscar viagem pelo veiculo
    @Query("SELECT v FROM Viagem v WHERE v.veiculo = :veiculo")
    public Optional<Viagem> findByVeiculo(@Param("veiculo") String veiculo);


    //    Bucar viagem por rg_onibus
    @Query("SELECT v FROM Viagem v WHERE v.registroOnibus = :registroOnibus")
    public Optional<Viagem> findByRegistroOnibus(@Param("registroOnibus") String registroOnibus);

}
