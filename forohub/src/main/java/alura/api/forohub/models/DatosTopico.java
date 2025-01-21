package alura.api.forohub.models;

import java.util.Date;

public record DatosTopico(
        Long id,
        String titulo,
        String mensaje,
        Date fechaDeCreacion,
        String status,
        String autor,
        String curso
) {

}
