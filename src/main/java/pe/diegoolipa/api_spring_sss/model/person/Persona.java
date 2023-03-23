package pe.diegoolipa.api_spring_sss.model.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;
    private String correo;

    @OneToMany(mappedBy = "persona")
    private Set<Cliente> cliente;
}
