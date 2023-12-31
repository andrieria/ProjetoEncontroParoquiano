package br.ifrn.projeto.integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.model.Equipe;
import br.ifrn.projeto.integrador.repository.EquipeRepository;


@Service
public class EquipeService {
    
    @Autowired
    private EquipeRepository equipeRepository; // Injete o seu repository de Equipe aqui

    public Equipe cadastrarEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe obterEquipePorId(Long id) {
        Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        return equipeOptional.orElse(null);
    }

    public List<Equipe> listarEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe atualizarEquipe(Equipe equipe) {
        // Verifique se a equipe existe no banco antes de atualizar
        if (equipeRepository.existsById(equipe.getId())) {
            return equipeRepository.save(equipe);
        }
        return null; // Equipe não encontrada para atualização
    }

    public void removerEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
