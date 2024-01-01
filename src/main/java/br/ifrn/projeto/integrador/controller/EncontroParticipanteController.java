package br.ifrn.projeto.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.Encontro;
import br.ifrn.projeto.integrador.model.EncontroParticipante;
import br.ifrn.projeto.integrador.service.EncontroParticipanteService;
import br.ifrn.projeto.integrador.service.EncontroService;

@RestController
@RequestMapping("encontroparticipante")
@CrossOrigin(origins = "*")
public class EncontroParticipanteController {

    @Autowired
    private EncontroParticipanteService encontroParticipanteService;

    @PostMapping
    public ResponseEntity<EncontroParticipante> criarEncontroParticipante(@RequestBody EncontroParticipante encontroParticipante) {
        EncontroParticipante novoEncontroParticipante = encontroParticipanteService.criarEncontroParticipante(encontroParticipante);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEncontroParticipante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncontroParticipante> buscarEncontroParticipantePorId(@PathVariable Long id) {
        EncontroParticipante encontroParticipante = encontroParticipanteService.buscarEncontroParticipantePorId(id);
        if (encontroParticipante != null) {
            return ResponseEntity.ok(encontroParticipante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncontroParticipante> atualizarEncontroParticipante(@PathVariable Long id, @RequestBody EncontroParticipante encontroParticipante) {
        EncontroParticipante encontroParticipanteAtualizado = encontroParticipanteService.atualizarEncontroParticipante(id, encontroParticipante);
        if (encontroParticipanteAtualizado != null) {
            return ResponseEntity.ok(encontroParticipanteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEncontroParticipante(@PathVariable Long id) {
        boolean deletado = encontroParticipanteService.deletarEncontroParticipante(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}