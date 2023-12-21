package br.ifrn.projeto.integrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String nomeLocal;


}
