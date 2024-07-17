package com.example.demo.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoDTO( String titulo,  String mensaje,
                              Long autorId,  Long cursoId) {
    public static TopicoDTO fromEntity(Topico topico) {
        return new TopicoDTO(

                topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuarioId(),
                topico.getCursoId()
        );
    }
}
