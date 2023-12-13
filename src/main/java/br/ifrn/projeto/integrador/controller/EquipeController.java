package br.ifrn.projeto.integrador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class EquipeController {
    
    /*Cada método vai ser uma rota  */
    
    @GetMapping("/listequipe")
    public String listarEquipe(){
        return "Listando";
    };

    @PostMapping("/postequipe")
    public String cadastrarEquipe(){
        return "Cadastrando";
    };
}
