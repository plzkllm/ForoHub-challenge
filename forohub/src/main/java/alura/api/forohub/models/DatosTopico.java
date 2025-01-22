package alura.api.forohub.models;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        @NotNull String status,
        String autor,
        String curso
) {

}
