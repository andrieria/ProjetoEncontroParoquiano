package br.ifrn.projeto.integrador.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.Cronograma;
import br.ifrn.projeto.integrador.model.CronogramaDTO;
import br.ifrn.projeto.integrador.service.CronogramaService;

/* import SM.SM.domain.cronograma.Cronograma;
import SM.SM.domain.cronograma.CronogramaDTO;
import SM.SM.service.CronogramaService; */

@RestController
@RequestMapping("cronograma")
public class CronogramaController {
   

    @Autowired
    private CronogramaService cronogramaService; // Injete seu service de Cronograma aqui

    @PostMapping("/montagem")
    public ResponseEntity<Cronograma> montarCronograma(@RequestBody CronogramaDTO montagemDTO) {
        Cronograma cronogramaMontado = cronogramaService.montarCronograma(montagemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cronogramaMontado);
    }

    @GetMapping("/visualização")
    public ResponseEntity<Cronograma> visualizarCronograma() {
        Cronograma cronograma = cronogramaService.obterCronograma();
        if (cronograma != null) {
            return ResponseEntity.ok(cronograma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
