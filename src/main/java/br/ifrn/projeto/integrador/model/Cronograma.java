package br.ifrn.projeto.integrador.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cronograma")
@Data
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

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private DateTimeFormat data_encontro;
    private String diaSemana;

    /*Falta o da hora, falta not blank e not null */
    private String nomeAtividade;
    
  
    

}
