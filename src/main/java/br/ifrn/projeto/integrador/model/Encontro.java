package br.ifrn.projeto.integrador.model;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="encontro")
@Data

public class Encontro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloEncontro;
    private int ano;
    /*falta endereço e as chaves estrangeiras com os relacionamentos */
    @Embedded
    private Endereco endereco;
    private String nomeLocal;
    @ManyToMany
    @JoinTable(
        name="encontro_participante", /*nome da terceira tabela */
        joinColumns = { 
            @JoinColumn(
                name="encontro_id", /*nome da minha coluna que vai ser gerada na terceira tabela */
                referencedColumnName = "id"/*vou informar qual campo do modelo Encontro vou utilizar para gerar o encontro_id */
                )
        },
        inverseJoinColumns = {
            @JoinColumn( /*agora estarei trabalhando com a chave primária do modelo Participante */
                name="participante_id",
                referencedColumnName = "id" /*id da entidade Participante */
                
            ) /*agora vou trabalhar com a chave primária do meu modelo Participante */
        }
    )
    private List<Participante> participantes;


    @OneToMany
    @JoinColumn(name="encontro_id")
    /*O nome dessa coluna vai ser a que tá na outra tabela, a chave estrangeira */
    private List<Cronograma> cronograma;


}
