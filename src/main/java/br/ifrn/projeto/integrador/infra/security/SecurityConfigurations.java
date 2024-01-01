package br.ifrn.projeto.integrador.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.Customizer;
import br.ifrn.projeto.integrador.service.ParticipanteService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfigurations  {


    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults());

        return http.csrf().disable()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and().authorizeHttpRequests()
              .requestMatchers(HttpMethod.POST, "/login", "/tarefa/**","/participante/**", "/equipe/**", "/encontro/**", "/cronograma","/encontroparticipante/**").permitAll()
              .requestMatchers(HttpMethod.GET, "/tarefa/**","/participante/**", "/equipe/**", "/encontro/**", "/cronograma","/encontroparticipante/**").permitAll()
              .requestMatchers(HttpMethod.PUT, "/login","/tarefa/**","/participante/**", "/equipe/**", "/encontro/**", "/cronograma","/encontro_participante/**").permitAll()
              .anyRequest().authenticated()
              .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
              .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
      return configuration.getAuthenticationManager();
    }
  
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}