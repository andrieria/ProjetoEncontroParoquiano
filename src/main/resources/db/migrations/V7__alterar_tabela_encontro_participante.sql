ALTER TABLE encontro_participante ADD CONSTRAINT fk_encontroParticipante_encontro FOREIGN KEY (encontro_id) REFERENCES encontro(id);
ALTER TABLE encontro_participante ADD CONSTRAINT fk_encontroParticipante_participante FOREIGN KEY (participante_id) REFERENCES participante(id);
ALTER TABLE encontro_participante ADD CONSTRAINT fk_encontroParticipante_equipe FOREIGN KEY (equipe_id) REFERENCES equipe(id);

