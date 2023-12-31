package br.ifrn.projeto.integrador.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/* import SM.SM.domain.encontro.Encontro;
import SM.SM.domain.equipe.Equipe; */
import br.ifrn.projeto.integrador.model.Participante;
import br.ifrn.projeto.integrador.repository.ParticipanteRepository;


@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;
    

    public Participante criarParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public Participante obterParticipantePorId(Long id) {
        return participanteRepository.findById(id).orElse(null);
    }

    public Participante atualizarParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public void deletarParticipante(Long id) {
        participanteRepository.deleteById(id);
    }
    
    public Participante obterParticipantePorLogin(String login) {
        return participanteRepository.findByLogin(login);
    }
}