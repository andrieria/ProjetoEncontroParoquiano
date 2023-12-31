CREATE TABLE encontro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    /*pode ser que seja necessário alterar o tipo do atributo da data porque
    na classe Cronograma tá o DateTimeFormat */
    titulo VARCHAR(100),
    ano INT,
    cep VARCHAR(9),
    estado VARCHAR(25),
    cidade VARCHAR(80),
    rua VARCHAR(250),
    numero INT, 
    bairro VARCHAR(150),
    complemento(500),
    nome_local VARCHAR(200)

);
    
    