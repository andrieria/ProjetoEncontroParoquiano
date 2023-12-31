package br.ifrn.projeto.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.model.Encontro;
import br.ifrn.projeto.integrador.repository.EncontroRepository;


@Service
public class EncontroService {

    @Autowired
    private EncontroRepository encontroRepository;


    public Encontro criarEncontro(Encontro encontro) {
        return encontroRepository.save(encontro);
    }

    public Encontro obterEncontroPorId(Long id) {
        return encontroRepository.findById(id).orElse(null);
    }

    public Encontro atualizarEncontro(Encontro encontro) {
        return encontroRepository.save(encontro);
    }

    public void deletarEncontro(Long id) {
        encontroRepository.deleteById(id);
    }
}
