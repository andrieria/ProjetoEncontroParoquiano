package br.ifrn.projeto.integrador.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="participante")
@Data
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;
    private String nome;
    private String telefone; /*tem como colocar o formato do telefone aqui?
    https://receitasdecodigo.com.br/java/numberformat-ou-decimalformat-formatar-numeros-reais-em-java
    https://cursos.alura.com.br/forum/topico-formatacao-de-valores-com-decimais-no-spring-boot-201280 */
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private DateTimeFormat dataNascimento;
    private String sexo;
    private String nivelEscolaridade;
    /*falta o endereço  */


}
