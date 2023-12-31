package br.ifrn.projeto.integrador.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*a classe model, serve para capturar os dados, que por padrão, não são
enviados pela URL*/ 

/*É o entity quem vai especificar a criação da tabela. Assim quando a criação do banco de dados (configuraçã do banco)
estiver ok, é o entity quem vai criar a tabela chamada Equipe, com os atributos/campos id, acessotarefa e nome.
Por padrão, a tabela no banco de dados segue o nome da classe, porém pode alterar isso. É só utilizar @Table.
 */
@Entity(name = "equipe")
@Table(name = "equipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Equipe {

    /*Quando trabalhamos com model é sempre bom deixar os atributos privados*/
    @Id
    /*Essa anotação @Id é responsável pela criação da chave primária. Ou seja,
    é essa anotation quem garante que nosso código seja interpretado/compreendido
    como uma chave primário (um registro).
    Para a chave primária ser auto incremento, a gente adiciona a anotação
    @GeneratedValue. Ela gera valores de forma crescente começando pelo número 1.
    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "acesso_tarefa")
    private String acessoTarefa;
    private String nome; 

    @OneToMany(mappedBy = "equipe")
    private Set<Tarefa> tarefas;
    /*O nome dessa coluna vai ser a que tá na outra tabela, a chave estrangeira */

    /*Essa característica diz que posso ter várias tarefas para uma só equipe.
     Ou seja, a gente criou a estrutura do relacionamento na entidade One (Equipe)
     no entanto, a coluna no banco de dados vai ser criada no lado Many(tarefas).
    */

    @OneToMany
    @JoinColumn(name="equipe_id")
    private List<EncontroParticipante> grupos;
}
