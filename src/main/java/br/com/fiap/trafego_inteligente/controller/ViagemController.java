package br.com.fiap.trafego_inteligente.controller;

import br.com.fiap.trafego_inteligente.dto.ViagemExibicaoDto;
import br.com.fiap.trafego_inteligente.dto.ViagemGravarDto;
import br.com.fiap.trafego_inteligente.model.Viagem;
import br.com.fiap.trafego_inteligente.service.ViagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ViagemController {

    @Autowired
    private ViagemService service;

    @PostMapping("/viagem")
    @ResponseStatus(HttpStatus.CREATED)
    public ViagemExibicaoDto gravar(@RequestBody @Valid ViagemGravarDto viagemGravarDto) {
        return service.gravar(viagemGravarDto);
    }

    @GetMapping("/viagem/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ViagemExibicaoDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/viagem")
    @ResponseStatus(HttpStatus.OK)
    public Page<ViagemExibicaoDto> buscarTodasViagens(Pageable paginacao) {
        return service.buscarTodasViagens(paginacao);
    }

    @DeleteMapping("/viagem/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluirViagem(id);
    }

    @PutMapping("/viagem")
    @ResponseStatus(HttpStatus.OK)
    public Viagem atualizar(@RequestBody Viagem viagem) {
        return service.atualizarViagem(viagem);
    }

    @GetMapping("/viagem/veiculo/{veiculo}")
    @ResponseStatus(HttpStatus.OK)
    public ViagemExibicaoDto buscarViagemPeloVeiculo(@PathVariable String veiculo) {
        return service.buscaVeiculo(veiculo);
    }


    @GetMapping("viagem/registroOnibus/{registroOnibus}")
    @ResponseStatus(HttpStatus.OK)
    public ViagemExibicaoDto buscarViagemPeloRg_onibus(@PathVariable String registroOnibus) {
        return service.buscaPorRegistroOnibus(registroOnibus);
    }

    ///api/viagem?veiculo=Ôninbus
//    @GetMapping(value = "/viagem", params = "veiculo")
//    public ViagemExibicaoDto buscarViagemPeloVeiculo(@RequestParam String veiculo){
//        return service.buscaVeiculo(veiculo);
//    }


}
