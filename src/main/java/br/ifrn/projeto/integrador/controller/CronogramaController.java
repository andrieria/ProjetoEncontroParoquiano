package br.ifrn.projeto.integrador.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.Cronograma;
// import br.ifrn.projeto.integrador.model.CronogramaDTO;
import br.ifrn.projeto.integrador.model.Tarefa;
import br.ifrn.projeto.integrador.service.CronogramaService;

/* import SM.SM.domain.cronograma.Cronograma;
import SM.SM.domain.cronograma.CronogramaDTO;
import SM.SM.service.CronogramaService; */

@RestController
@RequestMapping("cronograma")
@CrossOrigin(origins = "*")
public class CronogramaController {
   

    @Autowired
    private CronogramaService cronogramaService; // Injete seu service de Cronograma aqui

    
    @GetMapping
    public ResponseEntity<List<Cronograma>> visualizarCronograma() {
        List<Cronograma> cronogramas = cronogramaService.listarCronogramas();
        return ResponseEntity.ok(cronogramas);
    }

    @PostMapping
    public ResponseEntity<Cronograma> montarCronograma(@RequestBody Cronograma cronograma) {
        Cronograma cronogramaMontado = cronogramaService.montarCronograma(cronograma);
        return ResponseEntity.status(HttpStatus.CREATED).body(cronogramaMontado);
    }
}
