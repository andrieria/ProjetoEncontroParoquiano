CREATE TABLE encontro_participante(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nivel_acesso VARCHAR(30),
    encontro_id INT,
    participante_id INT,
    equipe_id INT
);