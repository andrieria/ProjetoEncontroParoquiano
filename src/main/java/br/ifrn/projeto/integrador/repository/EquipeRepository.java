package br.ifrn.projeto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.projeto.integrador.model.Equipe;

/*O repository é uma camada de persistência, ou seja, é a parte do projeto onde podemos efetuar ações de banco de dados,
como cadastros, seleções, alterações e exclusões.
 Esse arquivo é uma interface porque o objetivo da abstração do repositório Spring Data é reduzir 
 significativamente a quantidade de código padrão necessário para implementar camadas de acesso
  a dados para vários armazenamentos de persistência.

  https://glysns.gitbook.io/spring-framework/spring-data-jpa/o-poderoso-repository

  https://www.blip.ai/blog/tecnologia/persistencia-de-dados/

  

 
 */

@Repository
/*Ajuda ao spring a saber que isso é um repositório. 
 
*/
public interface EquipeRepository extends JpaRepository<Equipe, Long>{
    /*O tipo de chave primária, no lado direito, tem que ser representado
     por uma classe... se a chave primária fosse um inteiro, seria <Equipe, Integer>
     */
    
}
