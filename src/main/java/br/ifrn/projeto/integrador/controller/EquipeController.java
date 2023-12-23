package br.ifrn.projeto.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.projeto.integrador.model.Equipe;
import br.ifrn.projeto.integrador.repository.EquipeRepository;

/*As classes Controller servem para manipular rotas, e usaremos annotation.
Uma annotation serve para ensinar um framework a colocar uma ação diferente numa classe, num atributo ou método.


no GetMapping("boasVindas/{nomePessoa}"), o Spring tá pegando a informação da URL, nesse caso "nomePessoa" e tratando como uma variável.

    public String mensagem(@PathVariable String nomePessoa){
        return "Olá " + nomePessoa;
    };



A annotation @PathVariable tem como função, obter dados de uma url. Vamos supor que temos a seguinte rota: http://www.ralflima.com/curso/200, 
o termo curso é a nossa rota, já o valor 200 é o valor que desejamos obter utilizando a annotation @PathVariable.

Sempre que for necessário obter um dado via url, essa é uma das alternativas mais utilizadas no Spring para isso. 
Em aulas futuras iremos utilizar em nossa API para realizarmos ações com o banco MySQL.


@Data
https://projectlombok.org/features/Data#:~:text=%40Data%20is%20a%20convenient%20shortcut,beans%3A%20getters%20for%20all%20fields%2C



Uma entidade JPA (Java Persistence API) é uma classe Java que é mapeada para uma tabela em um banco de dados relacional. 
A JPA é uma especificação Java para persistência de dados, e ela fornece um conjunto de interfaces e anotações que facilitam 
o mapeamento objeto-relacional (ORM). O objetivo do mapeamento objeto-relacional é permitir que objetos Java sejam armazenados e
 recuperados de um banco de dados relacional de maneira transparente.

Principais características de uma entidade JPA:

Anotações JPA: As entidades JPA são geralmente marcadas com anotações específicas, como @Entity, @Table, @Id, entre outras. 
Essas anotações fornecem informações ao provedor JPA sobre como a classe deve ser mapeada para a tabela do banco de dados.

Identificador Primário (@Id): Cada entidade JPA deve ter um campo que atua como identificador primário. Esse campo é 
marcado com a anotação @Id e geralmente é usado para indexar exclusivamente cada registro na tabela do banco de dados.

Mapeamento de Relacionamentos: As entidades podem ter relacionamentos entre si, como relacionamentos muitos-para-um, um-para-muitos
 ou muitos-para-muitos. Esses relacionamentos são mapeados usando anotações como @ManyToOne, @OneToMany, @ManyToMany, etc.

Configuração da Unidade de Persistência: Para usar a JPA em uma aplicação Java, você precisa configurar uma unidade de persistência.
 Isso geralmente é feito por meio de um arquivo persistence.xml ou por configuração programática.

As entidades JPA simplificam a interação entre o código Java e o banco de dados, permitindo que desenvolvedores usem objetos Java para 
representar dados persistentes. Isso ajuda a abstrair detalhes específicos do banco de dados e facilita a manutenção e evolução da aplicação.




*/ 

@RestController /*trabalhar com API Rest */
@RequestMapping("/equipe")
/*Toda vez que escrevermos no final da URL /equipe, iremos ter acesso as 
 funcionalidades de EquipeController.
 */
public class EquipeController {
    
    /*Cada método vai ser uma rota  */

    @Autowired(required=true)
    /*Ela serve como um atalho. O desenvolvedor não precisa mais instanciar objetos
     para ter acesso a determinados métodos (injeção de dependência).

     */

     private EquipeRepository repositorio;
     /*Porque criou-se um objeto do tipo repositório? O nosso repositório vai 
     conter as ações do nosso banco de dados (cadastrar, alterar, listar e excluir), 
     então o objeto (repositorio) do tipo EquipeRepository pode chamar esses métodos.
     
     A criação de objetos tipo new Objeto objeto, quem faz, é a anotation @Autowired,
     quando a aplicação spring se iniciar. Resumindo, vou ter acesso a comandos CRUD do
     banco de dados sem precisar instanciar o objeto. 
      */
    
    @GetMapping("/listequipe")
    public String listarEquipe(){
        return "Listando";
    };

    @PostMapping("/postequipe")
    public String cadastrarEquipe(){
        return "Cadastrando";
    };

    /*Retornar dado do tipo equipe*/

    /*
    @PostMapping("/equipe") - essa é a anotation responsável pela rota, pq o GetMapping
    não tem suporte para o RequestBody. 
    public Equipe equipe(@RequestBody Equipe eq) {
        return eq;
    };*/


}






/*
 Inversão de Controle (IoC):

Normalmente, em um programa, você controla a execução das coisas. Com a IoC, 
você deixa essa responsabilidade para um sistema maior, como um framework.
Em vez de escrever código que cria e gerencia objetos, você delega essa tarefa a 
um "chefão" (como o Spring) que gerencia tudo para você.
A IoC inverte a maneira como você normalmente faria as coisas, passando o controle 
para algo maior.

Injeção de Dependências (DI):

Normalmente, quando uma classe precisa de algo (uma dependência), ela mesma cria 
esse algo. Com a DI, outra coisa (como o Spring) fornece essas dependências.
É como se você estivesse dizendo: "Ei, classe, você precisa disso e daquilo?
 Aqui está, alguém vai te dar essas coisas de que você precisa."
Em vez de classes se preocuparem em criar suas próprias dependências,
 elas recebem essas dependências de fora, tornando o código mais flexível e 
 fácil de testar.
 */
