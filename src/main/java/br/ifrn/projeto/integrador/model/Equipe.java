package br.ifrn.projeto.integrador.model;

import jakarta.persistence.Entity;

/*a classe model, serve para capturar os dados, que por padrão, não são
enviados pela URL*/ 
@Entity
public class Equipe {

    /*Quando trabalhamos com model é sempre bom deixar os atributos privados*/
    private boolean acessoTarefa;
    private String nome; 
}
