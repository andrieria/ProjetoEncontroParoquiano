package br.ifrn.projeto.integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.Participante;
import br.ifrn.projeto.integrador.service.ParticipanteService;


@RestController
@RequestMapping("participante")
@CrossOrigin(origins = "*")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    
    @PostMapping
    public ResponseEntity<Participante> criarParticipante(@RequestBody Participante participante) {
        String senhaCriptografada = bCryptPasswordEncoder.encode(participante.getSenha());
        participante.setSenha(senhaCriptografada);
    
        Participante participanteCriado = participanteService.criarParticipante(participante);
        return ResponseEntity.ok(participanteCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participante> obterParticipante(@PathVariable Long id) {
        Participante participante = participanteService.obterParticipantePorId(id);
        return ResponseEntity.ok(participante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participante> atualizarParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        participante.setId(id);
        Participante participanteAtualizado = participanteService.atualizarParticipante(participante);
        return ResponseEntity.ok(participanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarParticipante(@PathVariable Long id) {
        participanteService.deletarParticipante(id);
        return ResponseEntity.noContent().build();
    }
}