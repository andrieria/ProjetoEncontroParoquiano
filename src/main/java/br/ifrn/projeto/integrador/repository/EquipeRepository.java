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
    /*O lado esquerdo, é o modelo que quero trabalhar, nesse caso Equipe. */
    /*O tipo de chave primária, no lado direito, tem que ser representado
     por uma classe... se a chave primária fosse um inteiro, seria <Equipe, Integer >
     */

     /*
    Extends: Usamos a palavra-chave extends para herdar propriedades e métodos 
    de uma classe. A classe que atua como pai é chamada de classe base, e a classe 
    que herda dessa classe base é chamada de classe derivada ou filha. 
    Principalmente, a palavra-chave extends é usada para estender a 
    funcionalidade de uma classe pai para as classes derivadas. Além disso, 
    uma classe base pode ter muitas classes derivadas, mas uma classe derivada
     pode ter apenas uma classe base porque Java não suporta herança múltipla.


    Implements: Por outro lado, usamos a palavra-chave implements para implementar
     uma interface. Uma interface consiste apenas em métodos abstratos. 
     Uma classe implementará a interface e definirá esses métodos abstratos de 
     acordo com a funcionalidade necessária. Ao contrário de extends , qualquer 
     classe pode implementar múltiplas interfaces.


    Embora ambas as palavras-chave estejam alinhadas com o conceito de herança, 
    a palavra-chave implements é principalmente associada à abstração e usada para 
    definir um contrato, e extends é usada para estender a funcionalidade existente 
    de uma classe.



      */
    
}
