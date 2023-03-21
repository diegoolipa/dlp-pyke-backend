package pe.diegoolipa.api_spring_sss.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro")
    private Integer id;
    private String titulo;
    private String slug;
    private String descripcion;
    private String rutaPortada;
    private String rutaArchivo;
    private Float precio;
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_act")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    void asignarFechaCreacion(){
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    void asignarFechaActualizacion(){
        fechaActualizacion=LocalDateTime.now();
    }
}
