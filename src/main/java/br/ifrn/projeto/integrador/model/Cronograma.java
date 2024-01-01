package br.ifrn.projeto.integrador.model;

import java.time.LocalTime;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

// import br.ifrn.projeto.integrador.model.CronogramaDTO.DiaSemana;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "cronograma")
@Table(name="cronograma")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")

public class Cronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*Também podemos usar nossos próprios padrões de conversão, fornecendo um parâmetro padrão na anotação @DateTimeFormat : 
    @PostMapping("/date")
    public void date(@RequestParam("date") 
    @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
    // ...
}
    */
     /*not null aqui */
    
    @Column(name = "nome_atividade")
    private String nomeAtividade;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private DiaSemana diaSemana;
    private Date data;

    /*not blanmk aqui  */
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "encontro_id", referencedColumnName = "id")
    private Encontro encontro;
    public enum DiaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }
    // private int encontro_id;
    /*falta not blank e not null */
   
    
  
    

}
