package br.com.fiap.trafego_inteligente.service;

import br.com.fiap.trafego_inteligente.dto.ViagemExibicaoDto;
import br.com.fiap.trafego_inteligente.dto.ViagemGravarDto;
import br.com.fiap.trafego_inteligente.exception.ViagemNaoEncontradaException;
import br.com.fiap.trafego_inteligente.model.Viagem;
import br.com.fiap.trafego_inteligente.repository.ViagemRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository repository;

    public ViagemExibicaoDto gravar(ViagemGravarDto viagemGravarDto) {
        Viagem viagem = new Viagem();
        BeanUtils.copyProperties(viagemGravarDto, viagem);
        return new ViagemExibicaoDto(repository.save(viagem));
    }

    public Page<ViagemExibicaoDto> buscarTodasViagens(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(ViagemExibicaoDto::new);
    }

    public void excluirViagem(Long id) {
        Optional<Viagem> viagemoOptinal = repository.findById(id);

        if (viagemoOptinal.isPresent()) {
            repository.delete(viagemoOptinal.get());
        } else {
            throw new ViagemNaoEncontradaException("Viagem não encontrada para excluir!");
        }
    }

    public ViagemExibicaoDto atualizarViagem(ViagemGravarDto viagemGravarDto) {
        Viagem viagem = new Viagem();
        BeanUtils.copyProperties(viagemGravarDto, viagem);
        Optional<Viagem> viagemOptional = repository.findById(viagemGravarDto.id());

        if (viagemOptional.isPresent()) {
            return new ViagemExibicaoDto(repository.save(viagem));
        } else {
            throw new ViagemNaoEncontradaException("Viagem não encontrada!");
        }
    }

    public ViagemExibicaoDto buscarPorId(Long id) {
        Optional<Viagem> viagemOptional = repository.findById(id);
        if (viagemOptional.isPresent()) {
            return new ViagemExibicaoDto(viagemOptional.get());
        } else {
            throw new ViagemNaoEncontradaException("Viagem não encontrada!");
        }
    }


    public ViagemExibicaoDto buscaVeiculo(String veiculo) {
        Optional<Viagem> viagemOptional = repository.findByVeiculo(veiculo);

        if (viagemOptional.isPresent()) {
            return new ViagemExibicaoDto(viagemOptional.get());
        } else {
            throw new ViagemNaoEncontradaException("Veiculo não encontrado!");
        }
    }

    public ViagemExibicaoDto buscaPorRegistroOnibus(String registroOnibus) {
        Optional<Viagem> viagemOptional = repository.findByRegistroOnibus(registroOnibus);

        if (viagemOptional.isPresent()) {
            return new ViagemExibicaoDto(viagemOptional.get());
        } else {
            throw new ViagemNaoEncontradaException("Registro de Ônibus não encontrado!");
        }

    }


}
