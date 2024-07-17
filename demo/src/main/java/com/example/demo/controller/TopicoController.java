package com.example.demo.controller;

import com.example.demo.domain.topico.*;
import com.example.demo.domain.topico.DatosListadoTopico;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<TopicoDTO> crearTopico(@RequestBody @Valid CrearTopicoDTO crearTopicoDTO) {
        TopicoDTO topicoDTO = topicoService.crearTopico(crearTopicoDTO);
        return ResponseEntity.ok(topicoDTO);
    }

    @GetMapping
    public List<DatosListadoTopico> ListadoTopicos(){
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornarTopicoPorId(@PathVariable Long id) {
        try {
            Topico topico = topicoService.retornarTopicoPorId(id);
            if (topico == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tópico fue eliminado");
            }
            return ResponseEntity.ok(topico);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ID no existe o es nulo");
        }

    }

    @PutMapping
    @Transactional
    public ResponseEntity<Topico> actualizarTopico(@RequestBody @Valid DatosActualizacionTopico DatosActualizacionTopico){
        var topicoActualizado = topicoService.actualizarTopico(DatosActualizacionTopico);
        return ResponseEntity.ok(topicoActualizado);
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if (topicoExistente.isPresent()) {
            topicoService.eliminarTopico(id);
            return ResponseEntity.ok("Tópico eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ID del tópico no existe");
        }
    }

}
