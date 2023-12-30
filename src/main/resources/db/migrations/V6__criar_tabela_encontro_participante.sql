CREATE TABLE encontro_participante(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nivelAcesso VARCHAR(30),
    encontro_id INT,
    participante_id INT,
    equipe_id INT
);