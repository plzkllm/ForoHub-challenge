package alura.api.forohub.models;

import java.util.Date;

public record DatosTopicoParaImpresion(
        Long id,
        String titulo,
        String mensaje,
        String fechaDeCreacion,
        String autor,
        String curso
) {
    public DatosTopicoParaImpresion(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaDeCreacion().toString(), topico.getAutor(), topico.getNombreCurso());
    }
}
