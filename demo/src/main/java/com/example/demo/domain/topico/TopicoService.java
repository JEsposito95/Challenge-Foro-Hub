package com.example.demo.domain.topico;

import com.example.demo.domain.curso.Curso;
import com.example.demo.domain.curso.CursoRepository;
import com.example.demo.domain.usuario.Usuario;
import com.example.demo.domain.usuario.UsuarioRepository;
import com.example.demo.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public TopicoDTO crearTopico(CrearTopicoDTO crearTopicoDTO) {
        Usuario usuario = usuarioRepository.findById(crearTopicoDTO.autor_id())
                .orElseThrow(() -> new ValidacionDeIntegridad("Autor no encontrado"));
        Curso curso = cursoRepository.findById(crearTopicoDTO.curso_id())
                .orElseThrow(() -> new ValidacionDeIntegridad("Curso no encontrado"));

        boolean exists = topicoRepository.existsByTituloAndMensaje(crearTopicoDTO.titulo(), crearTopicoDTO.mensaje());
        if (exists) {
            throw new ValidacionDeIntegridad("El tópico con el mismo título y mensaje ya existe");
        }

        Topico topico = new Topico(crearTopicoDTO);

        topico.setUsuarioId(usuario.getId());
        topico.setCursoId(curso.getId());

        topico = topicoRepository.save(topico);
        return TopicoDTO.fromEntity(topico);
    }

    public Topico retornarTopicoPorId(Long id) {
        var topicoId = topicoRepository.getReferenceById(id);
        if (!topicoId.getStatus()){
            return null;
        }
        return topicoId;
    }

    public Topico actualizarTopico(DatosActualizacionTopico datosActualizacionTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizacionTopico.id());
        topico.setTitulo(datosActualizacionTopico.titulo());
        topico.setMensaje(datosActualizacionTopico.mensaje());
        return topico;
}

    public void eliminarTopico(Long id) {
        var topicoEliminar = topicoRepository.getReferenceById(id);
        topicoEliminar.setStatus(false);
    }

}
