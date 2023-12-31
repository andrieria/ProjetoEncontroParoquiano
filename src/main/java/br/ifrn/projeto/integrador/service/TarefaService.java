package br.ifrn.projeto.integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.model.Tarefa;
import br.ifrn.projeto.integrador.repository.TarefaRepository;


@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository; // Injete seu repository de Tarefa aqui

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa cadastrarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
