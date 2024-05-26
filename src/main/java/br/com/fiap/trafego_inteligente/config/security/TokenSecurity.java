package br.com.fiap.trafego_inteligente.config.security;

import br.com.fiap.trafego_inteligente.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenSecurity {

    @Value("${chave.secreta}")
    private String palavraSecreta;

    public String gerarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(this.palavraSecreta);
            String token = JWT.create().withIssuer("viagem")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(dataDeExpiracaoToken())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException error) {
            throw new RuntimeException("Não foi possivel geral o Token");
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
            return JWT.require(algorithm)
                    .withIssuer("viagem")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException erro) {
            return "";
        }
    }


    public Instant dataDeExpiracaoToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
