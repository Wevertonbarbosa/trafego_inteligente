package br.com.fiap.trafego_inteligente.service;

import br.com.fiap.trafego_inteligente.dto.UsuarioCadastroDto;
import br.com.fiap.trafego_inteligente.dto.UsuarioExibicaoDto;
import br.com.fiap.trafego_inteligente.model.Usuario;
import br.com.fiap.trafego_inteligente.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioDto) {
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(usuarioSalvo);
    }

    public UsuarioExibicaoDto buscarPorid(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado no Banco de dados!");
        }
    }

    public List<UsuarioExibicaoDto> listarTodos() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado para excluir!!");
        }

    }

    public Usuario atualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(usuario.getUsuarioId());

        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }


}
