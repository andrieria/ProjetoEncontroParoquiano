package br.ifrn.projeto.integrador.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


import br.ifrn.projeto.integrador.model.Participante;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.estoque.token.secret}")
    private String seacret;

    public String gerarToken(Participante participante) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(seacret);
            return JWT.create()
                    .withIssuer("Encontro Conectado")
                    .withSubject(participante.getLogin())
                    .withClaim("id", participante.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(seacret);
            return JWT.require(algorithm)
                // specify an specific claim validations
                .withIssuer("Encontro Conectado")
                // reusable verifier instance
                .build().verify(tokenJWT).getSubject();
      
          } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token inválido ou expirado");
          }
        }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}