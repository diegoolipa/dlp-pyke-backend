package pe.diegoolipa.api_spring_sss.model.person;

import jakarta.persistence.*;
import lombok.Data;
import pe.diegoolipa.api_spring_sss.model.store.Compra;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private Integer idPersona;
    private Boolean estado;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @OneToOne
    @JoinColumn(name = "idPersona", insertable = false, updatable = false)
    private Persona persona;
}
