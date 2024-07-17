//package com.example.demo.domain.respuesta;
//
//import com.example.demo.domain.curso.Curso;
//import com.example.demo.domain.usuario.Usuario;
//import com.example.demo.domain.topico.Topico;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Table(name="respuestas")
//@Entity(name="Respuesta")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Respuesta {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String mensaje;
//    private Topico topico;
//
//    private LocalDateTime fechaCreacion;
//    private Usuario usuario;
//    private Curso curso;
//    private Respuesta respuesta;
//
//}
