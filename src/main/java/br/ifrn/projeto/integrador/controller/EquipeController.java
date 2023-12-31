package br.ifrn.projeto.integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/* 
import SM.SM.domain.equipe.Equipe;
import SM.SM.service.EquipeService; */

import br.ifrn.projeto.integrador.model.Equipe;
import br.ifrn.projeto.integrador.service.EquipeService;

@RestController
@RequestMapping("equipe")
public class EquipeController {
    
    @Autowired
    private EquipeService equipeService;

    @PostMapping
    public ResponseEntity<Equipe> cadastrarEquipe(@RequestBody Equipe equipe) {
        Equipe equipeCadastrada = equipeService.cadastrarEquipe(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipeCadastrada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> obterEquipePorId(@PathVariable Long id) {
        Equipe equipe = equipeService.obterEquipePorId(id);
        if (equipe != null) {
            return ResponseEntity.ok(equipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> listarEquipes() {
        List<Equipe> equipes = equipeService.listarEquipes();
        return ResponseEntity.ok(equipes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> atualizarEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        equipe.setId(id);
        Equipe equipeAtualizada = equipeService.atualizarEquipe(equipe);
        return ResponseEntity.ok(equipeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEquipe(@PathVariable Long id) {
        equipeService.removerEquipe(id);
        return ResponseEntity.noContent().build();
    }
}
