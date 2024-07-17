package com.example.demo.domain.topico;

import com.example.demo.domain.curso.Curso;
import com.example.demo.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    private LocalDateTime fechaDeCreacion;
    private Boolean status;


    @JoinColumn(name = "usuario_id")
    private Long usuarioId;


    @JoinColumn(name = "curso_id")
    private Long cursoId;

    public Topico(CrearTopicoDTO crearTopicoDTO) {
        this.status=true;
        this.setFechaDeCreacion(LocalDateTime.now());
        this.setTitulo(crearTopicoDTO.titulo());
        this.setMensaje(crearTopicoDTO.mensaje());

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
