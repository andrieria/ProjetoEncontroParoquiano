package br.ifrn.projeto.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.model.Cronograma;
// import br.ifrn.projeto.integrador.model.CronogramaDTO;
import br.ifrn.projeto.integrador.model.Encontro;
import br.ifrn.projeto.integrador.model.EncontroParticipante;
import br.ifrn.projeto.integrador.repository.CronogramaRepository;
import br.ifrn.projeto.integrador.repository.EncontroParticipanteRepository;
import br.ifrn.projeto.integrador.repository.EncontroRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class EncontroParticipanteService {

    @Autowired
    private EncontroParticipanteRepository encontroParticipanteRepository;

    public EncontroParticipante criarEncontroParticipante(EncontroParticipante encontroParticipante) {
        // Aqui você pode realizar validações ou lógica de negócios antes de salvar
        return encontroParticipanteRepository.save(encontroParticipante);
    }

    public EncontroParticipante buscarEncontroParticipantePorId(Long id) {
        return encontroParticipanteRepository.findById(id).orElse(null);
    }

    public EncontroParticipante atualizarEncontroParticipante(Long id, EncontroParticipante encontroParticipante) {
        // Verifica se o encontroParticipante com o ID fornecido existe no banco de dados
        EncontroParticipante existente = encontroParticipanteRepository.findById(id).orElse(null);
        if (existente != null) {
            // Define o ID do encontroParticipante a ser atualizado e salva as alterações
            encontroParticipante.setId(id);
            return encontroParticipanteRepository.save(encontroParticipante);
        }
        return null;
    }

    public boolean deletarEncontroParticipante(Long id) {
        // Verifica se o encontroParticipante com o ID fornecido existe no banco de dados
        EncontroParticipante existente = encontroParticipanteRepository.findById(id).orElse(null);
        if (existente != null) {
            // Remove o encontroParticipante
            encontroParticipanteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}