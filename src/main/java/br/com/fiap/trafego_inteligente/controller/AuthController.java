package br.com.fiap.trafego_inteligente.controller;

import br.com.fiap.trafego_inteligente.config.security.TokenSecurity;
import br.com.fiap.trafego_inteligente.dto.LoginDto;
import br.com.fiap.trafego_inteligente.dto.TokenDto;
import br.com.fiap.trafego_inteligente.dto.UsuarioCadastroDto;
import br.com.fiap.trafego_inteligente.dto.UsuarioExibicaoDto;
import br.com.fiap.trafego_inteligente.model.Usuario;
import br.com.fiap.trafego_inteligente.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenSecurity tokenSecurity;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(), loginDto.senha()
                );
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenSecurity.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDto(token));
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        UsuarioExibicaoDto usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(usuarioCadastroDto);
        return usuarioSalvo;
    }

}
