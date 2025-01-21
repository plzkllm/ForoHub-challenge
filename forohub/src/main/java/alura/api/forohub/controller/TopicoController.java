package alura.api.forohub.controller;

import alura.api.forohub.models.DatosTopico;
import alura.api.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String

    @PutMapping

    @DeleteMapping("/{id}")
}
