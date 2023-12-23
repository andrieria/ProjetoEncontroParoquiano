/*Muito pertinente sua dúvida e ela vai pro nível de boas práticas e legibilidade 
dentro do seu código.

As migrations são uma forma de versionar o seu banco de dados. Já pensou 
trabalhar com projetos sem o git? Com certeza daria muito mais trabalho 
para reverter um erro ou entender o código, não é verdade? As migrations atuam 
nesse sentido, e são necessárias para garantir a consistência e a integridade 
do banco de dados ao longo do tempo, especialmente quando há várias versões do
 seu projeto em produção.

Ao utilizar migrations, você tem um controle mais preciso sobre as alterações no 
esquema do banco de dados. Em vez de depender apenas da criação automática das 
tabelas, você pode definir as alterações no esquema de forma programática, 
tornando o processo mais organizado e rastreável.*/

/*CREATE TABLE cronograma (
    id INT AUTO_INCREMENT PRIMARY KEY,
    /*pode ser que seja necessário alterar o tipo do atributo da data porque
    na classe Cronograma tá o DateTimeFormat */
    dataEncontro DATE,
    diaSemana VARCHAR(100),
    nomeAtividade VARCHAR(200),
    /*falta a hora*/

