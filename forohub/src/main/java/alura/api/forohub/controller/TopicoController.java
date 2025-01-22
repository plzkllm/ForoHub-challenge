package alura.api.forohub.controller;

import alura.api.forohub.models.DatosActualizarTopico;
import alura.api.forohub.models.DatosTopico;
import alura.api.forohub.models.DatosTopicoParaImpresion;
import alura.api.forohub.models.Topico;
import alura.api.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosTopicoParaImpresion>> listarTopicos(@PageableDefault(size = 5) Pageable pagina){
        return ResponseEntity
                .ok(topicoRepository
                        .findByStatusTrue(pagina)
                        .map(DatosTopicoParaImpresion::new));
    }

    @PostMapping
    public ResponseEntity<DatosTopicoParaImpresion> insertarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uri){
        Topico topico = new Topico(datosTopico);
        DatosTopicoParaImpresion datosAImprimir = new DatosTopicoParaImpresion(topico.getId(),
                topico.getTitulo(),topico.getMensaje(),
                topico.getFechaDeCreacion().toString(),
                topico.getAutor(),topico.getNombreCurso());

        URI url= uri.path("/topicos/{id}").buildAndExpand(datosTopico.id()).toUri();
        return ResponseEntity.created(url).body(datosAImprimir);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosTopico){
        Topico topico = topicoRepository.getReferenceById(datosTopico.id());
        topico.modificacion(datosTopico);
        //titulo
        // mensaje
        //nombreCurso
        return ResponseEntity.ok(new DatosTopicoParaImpresion(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.eliminarTopico(); //borrado logico
        return ResponseEntity.noContent().build();
    }
}
