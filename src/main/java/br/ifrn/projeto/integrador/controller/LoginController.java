package br.ifrn.projeto.integrador.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.DadosAutenticacao;
import br.ifrn.projeto.integrador.model.Participante;
import br.ifrn.projeto.integrador.infra.security.DadosTokenJWT;
import br.ifrn.projeto.integrador.service.ParticipanteService;
import br.ifrn.projeto.integrador.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*")
public class LoginController {
      
    @Autowired
    private AuthenticationManager manager;

  
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    TokenService tokenService;
    
    @Autowired
    private ParticipanteService participanteService;

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Participante) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
  }

    @GetMapping
    public ResponseEntity<String> getSenhaBcrypt(@RequestBody String senha){
        String senhaBrypt = bCryptPasswordEncoder.encode(senha);
        return ResponseEntity.ok(senhaBrypt);
  }
}
