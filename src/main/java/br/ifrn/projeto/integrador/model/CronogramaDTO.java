package br.ifrn.projeto.integrador.model;

import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CronogramaDTO {
    private String nomeAtividade;
    private Cronograma.DiaSemana diaSemana;
    private Date data;
    private LocalTime hora;
    private Long idEncontro; // Para associar o cronograma a um encontro específico

    // Enumeração para os dias da semana
    public enum DiaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }
}
