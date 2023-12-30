package br.ifrn.projeto.integrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tarefa")
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tituloTarefa;
    private String descricao; 

    /*falta chaves estrangeiras e relacionamentos */
    /*private int equipe_id;*/
}
