CREATE TABLE participante(
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(200),
    senha VARCHAR(300),
    nome VARCHAR(500),
    telefone VARCHAR(13),
    data_nascimento DATE,
    sexo VARCHAR(40),
    escolaridade VARCHAR(50),
    cep VARCHAR(9),
    estado VARCHAR(25),
    cidade VARCHAR(80),
    rua VARCHAR(250),
    numero INT, 
    bairro VARCHAR(150),
    complemento(500)
    
);