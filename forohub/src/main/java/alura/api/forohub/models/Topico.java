package alura.api.forohub.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaDeCreacion;
    private boolean status;
    private String autor;
    private String nombreCurso;

    public Topico(DatosTopico datosTopico) {
        this.titulo= datosTopico.titulo();
        this.mensaje= datosTopico.mensaje();;
        this.fechaDeCreacion=new Date().toString();
        this.status=true;
        this.autor= datosTopico.autor();
        this.nombreCurso= datosTopico.curso();

    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void modificacion(DatosActualizarTopico datosTopico) {
        if(datosTopico.curso() != null){
            this.nombreCurso= datosTopico.curso();
        }
        if(datosTopico.mensaje()!= null){
            this.mensaje= datosTopico.mensaje();
        }
        if(datosTopico.titulo()!=null){
            this.titulo= datosTopico.titulo();
        }
    }

    public void eliminarTopico(){
        this.status=false;
    }
}
