CREATE TABLE respuestas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    usuario_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    solucion TINYINT DEFAULT 0,

    PRIMARY KEY(id),

    CONSTRAINT fk_respuestas_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_respuestas_topico_id FOREIGN KEY(topico_id) REFERENCES topicos(id)

);