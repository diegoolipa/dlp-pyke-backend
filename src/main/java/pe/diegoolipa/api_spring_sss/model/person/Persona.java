package pe.diegoolipa.api_spring_sss.model.person;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idPersona;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;
    private String correo;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Cliente cliente;
}
