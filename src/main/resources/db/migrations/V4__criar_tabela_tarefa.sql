CREATE TABLE tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tituloTarefa varchar(300),
    descricao varchar(800),
    idEquipe int,

    ALTER TABLE tarefa ADD CONSTRAINT fk_tarefa_equipe FOREIGN KEY (idEquipe) REFERENCES equipe(id)

)