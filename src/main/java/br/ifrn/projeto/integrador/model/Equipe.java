package br.ifrn.projeto.integrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*a classe model, serve para capturar os dados, que por padrão, não são
enviados pela URL*/ 
@Entity
/*É o entity quem vai especificar a criação da tabela. Assim quando a criação do banco de dados (configuraçã do banco)
estiver ok, é o entity quem vai criar a tabela chamada Equipe, com os atributos/campos id, acessotarefa e nome.
Por padrão, a tabela no banco de dados segue o nome da classe, porém pode alterar isso. É só utilizar @Table.
 */
@Table(name="equipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Equipe {

    /*Quando trabalhamos com model é sempre bom deixar os atributos privados*/
    @Id
    /*Essa anotação @Id é responsável pela criação da chave primária.
    Para a chave primária ser auto incremento, a gente adiciona a anotação
    @GeneratedValue. Ela gera valores de forma crescente começando pelo número 1.
    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean acessoTarefa;
    private String nome; 
}
