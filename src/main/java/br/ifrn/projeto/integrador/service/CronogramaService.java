package br.ifrn.projeto.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.model.Cronograma;
import br.ifrn.projeto.integrador.model.CronogramaDTO;
import br.ifrn.projeto.integrador.model.Encontro;
import br.ifrn.projeto.integrador.repository.CronogramaRepository;
import br.ifrn.projeto.integrador.repository.EncontroRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CronogramaService {
   
    @Autowired
    private  CronogramaRepository cronogramaRepository;
    
    @Autowired
    private  EncontroRepository encontroRepository;

    public Cronograma montarCronograma(CronogramaDTO montagemDTO) {
        // Busca o encontro associado ao ID fornecido no DTO
        Encontro encontro = encontroRepository.findById(montagemDTO.getIdEncontro())
            .orElseThrow(() -> new EntityNotFoundException("Encontro não encontrado com o ID: " + montagemDTO.getIdEncontro()));

        // Criação do cronograma com os dados do DTO
        Cronograma cronograma = new Cronograma();
        cronograma.setNomeAtividade(montagemDTO.getNomeAtividade());
        cronograma.setDiaSemana(montagemDTO.getDiaSemana());
        cronograma.setData(montagemDTO.getData());
        cronograma.setHora(montagemDTO.getHora());
        cronograma.setEncontro(encontro);

        // Salva o cronograma
        return cronogramaRepository.save(cronograma);
    }

    public Cronograma obterCronograma() {
        // Lógica para obter o último cronograma salvo, por exemplo
        return cronogramaRepository.findFirstByOrderByIdDesc();
    }
}
