package com.example.demo.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearTopicoDTO(@NotBlank String titulo, @NotBlank String mensaje,
                             @NotNull Long autor_id, @NotNull Long curso_id) {

    }


