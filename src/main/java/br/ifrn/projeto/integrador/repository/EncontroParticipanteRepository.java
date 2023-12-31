package br.ifrn.projeto.integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.projeto.integrador.model.EncontroParticipante;

// @Repository
public interface EncontroParticipanteRepository extends JpaRepository<EncontroParticipante, Long> {
     List<EncontroParticipante> findByEncontroId(Long encontroId);

    List<EncontroParticipante> findByParticipanteId(Long participanteId);
}
