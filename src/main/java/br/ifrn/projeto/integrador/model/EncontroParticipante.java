package br.ifrn.projeto.integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="encontro_participante")
@Data
@EqualsAndHashCode(of="id")
public class EncontroParticipante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nivel_acesso")
    private Prioridade nivelAcesso;

    /*falta as chaves estrangeiras e os relacionamentos  */
    @ManyToOne
    @JoinColumn(name = "encontro_id ")
    private Encontro encontro;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}
