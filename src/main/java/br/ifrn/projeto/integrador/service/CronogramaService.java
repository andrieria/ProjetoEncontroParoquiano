package br.ifrn.projeto.integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.model.Cronograma;
// import br.ifrn.projeto.integrador.model.CronogramaDTO;
import br.ifrn.projeto.integrador.model.Encontro;
import br.ifrn.projeto.integrador.model.Tarefa;
import br.ifrn.projeto.integrador.repository.CronogramaRepository;
import br.ifrn.projeto.integrador.repository.EncontroRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CronogramaService {
   
    @Autowired
    private  CronogramaRepository cronogramaRepository;
    
    @Autowired
    private  EncontroRepository encontroRepository;

    public Cronograma montarCronograma(Cronograma cronograma) {
        // Busca o encontro associado ao ID fornecido no cronograma
        Encontro encontro = encontroRepository.findById(cronograma.getEncontro().getId())
            .orElseThrow(() -> new EntityNotFoundException("Encontro não encontrado com o ID: " + cronograma.getEncontro().getId()));

        // Cria um novo objeto Cronograma e define os valores
        Cronograma novoCronograma = new Cronograma();
        novoCronograma.setNomeAtividade(cronograma.getNomeAtividade());
        novoCronograma.setDiaSemana(cronograma.getDiaSemana());
        novoCronograma.setData(cronograma.getData());
        novoCronograma.setHora(cronograma.getHora());
        novoCronograma.setEncontro(encontro);

        // Salva o cronograma criado
        return cronogramaRepository.save(novoCronograma);
    }

    // Restante dos métodos...

/*     public Cronograma obterCronograma() {
        // Lógica para obter o último cronograma salvo, por exemplo
        return cronogramaRepository.findFirstByOrderByIdDesc();
    } */

    public List<Cronograma> listarCronogramas() {
        return cronogramaRepository.findAll();
    }
}
