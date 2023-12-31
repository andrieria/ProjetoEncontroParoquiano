package br.ifrn.projeto.integrador.model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="cronograma")
@Data
@EqualsAndHashCode(of="id")

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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dataDiaEncontro;

    /*not blanmk aqui  */
    private String diaSemana;
    private String nomeAtividade;
    private String hora;

    private int encontro_id;
    /*falta not blank e not null */
   
    
  
    

}
