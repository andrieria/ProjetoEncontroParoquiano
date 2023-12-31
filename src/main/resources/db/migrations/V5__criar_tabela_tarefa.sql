CREATE TABLE tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tituloTarefa VARCHAR(300),
    descricao VARCHAR(800),
    equipe_id INT


);

ALTER TABLE tarefa ADD CONSTRAINT fk_tarefa_equipe FOREIGN KEY (equipe_id) REFERENCES equipe(id);