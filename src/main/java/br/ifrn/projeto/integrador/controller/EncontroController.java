package br.ifrn.projeto.integrador.controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.Encontro;
import br.ifrn.projeto.integrador.service.EncontroService;

// import SM.SM.domain.encontro.Encontro;
// import SM.SM.domain.participante.Participante;
// import SM.SM.service.EncontroService;
// import SM.SM.service.ParticipanteService;

@RestController
@RequestMapping("encontro")
public class EncontroController {

    @Autowired
    private EncontroService encontroService;

/*     @Autowired
    private ParticipanteService participanteService; */
    
    @PostMapping
    public ResponseEntity<Encontro> criarEncontro(@RequestBody Encontro encontro) {
        Encontro encontroCriado = encontroService.criarEncontro(encontro);
        return ResponseEntity.ok(encontroCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encontro> obterEncontro(@PathVariable Long id) {
        Encontro encontro = encontroService.obterEncontroPorId(id);
        return ResponseEntity.ok(encontro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encontro> atualizarEncontro(@PathVariable Long id, @RequestBody Encontro encontro) {
        encontro.setId(id);
        Encontro encontroAtualizado = encontroService.atualizarEncontro(encontro);
        return ResponseEntity.ok(encontroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEncontro(@PathVariable Long id) {
        encontroService.deletarEncontro(id);
        return ResponseEntity.noContent().build();
    }
}