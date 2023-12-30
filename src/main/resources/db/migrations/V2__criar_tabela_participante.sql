CREATE TABLE participante(
    id INT AUTO_INCREMENT PRIMARY KEY,
    loginParticipante VARCHAR(200),
    senhaParticipante VARCHAR(300),
    nome VARCHAR(500),
    telefone VARCHAR(13),
    dataNascimento DATE,
    sexo VARCHAR(40),
    nivelEscolaridade VARCHAR(50),
    cep VARCHAR(9),
    estado VARCHAR(25),
    cidade VARCHAR(80),
    rua VARCHAR(250),
    numero INT, 
    bairro VARCHAR(150),
    complemento(500)
    
);