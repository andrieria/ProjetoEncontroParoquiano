package br.ifrn.projeto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.projeto.integrador.model.Cronograma;

@Repository
public interface CronogramaRepository extends JpaRepository<Cronograma, Long>{
    
}
