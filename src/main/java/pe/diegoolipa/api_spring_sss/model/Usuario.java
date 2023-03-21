package pe.diegoolipa.api_spring_sss.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;
    private String nombres;
    private String apellidos;
    private String nombre_completo;
    private String password;
    private String rol;
    @Column(name = "email")
    private String correo_electronico;
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
