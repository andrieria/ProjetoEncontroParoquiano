package br.ifrn.projeto.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ifrn.projeto.integrador.repository.ParticipanteRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

  @Autowired
  private ParticipanteRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repository.findByLogin(username);
  }

}