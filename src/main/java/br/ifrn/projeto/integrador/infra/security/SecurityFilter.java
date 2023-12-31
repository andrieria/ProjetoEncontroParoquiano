package br.ifrn.projeto.integrador.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.ifrn.projeto.integrador.model.Participante;
import br.ifrn.projeto.integrador.repository.ParticipanteRepository;
import br.ifrn.projeto.integrador.service.ParticipanteService;
import br.ifrn.projeto.integrador.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

/*     @Autowired
    private ParticipanteService participanteService;
 */
    @Autowired
    private ParticipanteRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
      var tokenJWT = recuperarToken(request);
      if (tokenJWT != null) {
        var subject = tokenService.getSubject(tokenJWT);
        var participante = repository.findByLogin(subject);
        var authentication = new UsernamePasswordAuthenticationToken(participante, null, participante.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
  
      filterChain.doFilter(request, response);
    }
  
    private String recuperarToken(HttpServletRequest request) {
      var authorizationHeader = request.getHeader("Authorization");
      /*
       * if (authorizationHeader == null) {
       * throw new RuntimeException("TOKEN JWT não enviado");
       * }
       */
      if (authorizationHeader != null) {
        return authorizationHeader.replace("Bearer ", "");
      }
      return null;
    }
}