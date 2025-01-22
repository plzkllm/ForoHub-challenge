package alura.api.forohub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;

import java.util.Date;

@Entity
public class Topico {
    @Id
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaDeCreacion;
    private boolean status;
    private String autor;
    private String nombreCurso;

    public Topico(DatosTopico datosTopico) {
        this.titulo= datosTopico.titulo();
        this.mensaje= datosTopico.mensaje();;
        this.fechaDeCreacion=datosTopico.fechaDeCreacion();
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

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
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
