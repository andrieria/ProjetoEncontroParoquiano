package br.ifrn.projeto.integrador.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// import javax.validation.constraints.Pattern;

@Entity(name = "participante")
@Table(name = "participante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Participante implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;
    private String nome;

   //  @Pattern(regexp = "^\\(\\d{2}\\)\\d{9}$", message = "Formato de telefone inválido. Use o formato (XX)XXXXXXXXX")
    private String telefone; 
    /*https://receitasdecodigo.com.br/java/numberformat-ou-decimalformat-formatar-numeros-reais-em-java
    https://cursos.alura.com.br/forum/topico-formatacao-de-valores-com-decimais-no-spring-boot-201280 */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private String dataNascimento;

    private String sexo;
    private String escolaridade;
    /*falta o endereço  */
    @Embedded
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao", 
        joinColumns = @JoinColumn(name = "participante_id"), 
        inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private Set<Permissao> permissoes = new HashSet<>();
    
    @ManyToMany(mappedBy = "participantes")
    /*o nome "participantes" é o mesmo que está na lista na Entidade Encontro */ 
    /* O mappedBy, no ManyToMany, o Spring entende que encontros abaixo 
    dessa linha (que é uma lista), não vai criar uma nova tabela porque já temos
    uma tabela pré definida pra ser criada que está na classe/entidade Encontro.
    */
    private List<Encontro> encontros;


    /*
     * Tipo da Associação	Opção
        One-to-one	       Qualquer um dos lados pode ser o dono, mas apenas um deles
                           deve realmente ser o dono. Se isso não for especificado 
                           teremos uma dependência circular.

        One-to-many	        O lado "many" da associação deve ser tornado como o dono 
                            da associação.
        Many-to-one	Este é como o de cima, porém visualizado sob uma perspectiva oposta, mas a mesma regra se aplica - o lado “many” é o dono da associação.
        Many-to-many	Qualquer um dos lados pode ser o dono da associação.
     */
   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<? extends GrantedAuthority> authorities = this.permissoes.stream().map(
      permissao -> new SimpleGrantedAuthority(permissao.getNome())).
      collect(Collectors.toList());
      System.out.println(this.login + "  " + " " + authorities.toString());
      return authorities;
  }

  @Override
  public String getPassword() {
    return this.senha;
  }
  @Override
  public String getUsername() {
    return this.login;
  }
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  } 
}
