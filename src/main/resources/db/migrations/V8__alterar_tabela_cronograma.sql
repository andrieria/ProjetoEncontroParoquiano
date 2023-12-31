ALTER TABLE cronograma ADD CONSTRAINT fk_cronograma_encontro FOREIGN KEY (encontro_id) REFERENCES encontro(id);
