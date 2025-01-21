package alura.api.forohub.controller;

import alura.api.forohub.models.DatosTopico;
import alura.api.forohub.models.DatosTopicoParaImpresion;
import alura.api.forohub.models.Topico;
import alura.api.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<DatosTopico> listarTopicos(){

        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosTopico::new));
    }

    @PostMapping
    public ResponseEntity<DatosTopicoParaImpresion> insertarTopico(@RequestBody @Valid DatosTopico datosTopico,UriComponentsBuilder uri){
        Topico topico = new Topico(datosTopico);
        DatosTopicoParaImpresion datosAImprimir = new DatosTopicoParaImpresion(topico.getId(),
                topico.getTitulo(),topico.getMensaje(),
                topico.getFechaDeCreacion().toString(),
                topico.getAutor(),topico.getNombreCurso());

        URI url= uri.path("/medicos/{id}").buildAndExpand(datosTopico.id()).toUri();
        return ResponseEntity.created(url).body(datosAImprimir);
    }

    @PutMapping
    @Transactional
    public String actualizarTopico(@RequestBody @Valid DatosTopico datosTopico){
    //titulo
        //mensaje
        //nombreCurso
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String eliminarTopico(@PathVariable Long id){

    }
}
