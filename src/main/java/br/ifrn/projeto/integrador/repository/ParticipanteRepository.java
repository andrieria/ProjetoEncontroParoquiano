package br.ifrn.projeto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.projeto.integrador.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    
}
