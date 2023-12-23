package br.ifrn.projeto.integrador.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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


    @ManyToMany(mappedBy = "participantes") 
    /* O mappedBy, no ManyToMany, o Spring entende que encontros abaixo 
    dessa linha (que é uma lista), não vai criar uma nova tabela porque já temos
    uma tabela pré definida pra ser criada que está na classe/entidade Encontro.
    */
    private List<Encontro> encontros = new ArrayList<>();


    /*
     * Tipo da Associação	Opção
        One-to-one	       Qualquer um dos lados pode ser o dono, mas apenas um deles
                           deve realmente ser o dono. Se isso não for especificado 
                           teremos uma dependência circular.

        One-to-many	        O lado "many" da associação deve ser tornado como o dono 
                            da associação.
        Many-to-one	Este é como o de cima, porém visualizado sob uma perspectiva oposta, mas a mesma regra se aplica - o lado “many” é o dono da associação.
        Many-to-many	Qualquer um dos lados pode ser o dono da associação.
     */

}
