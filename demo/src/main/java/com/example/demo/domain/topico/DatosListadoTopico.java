package com.example.demo.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo, String mensaje, LocalDateTime fechaDeCreacion,
                                 Long autorId, Long cursoId) {

    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFechaDeCreacion(),
                topico.getUsuarioId(),topico.getCursoId());
    }


}
