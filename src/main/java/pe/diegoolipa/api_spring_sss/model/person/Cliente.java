package pe.diegoolipa.api_spring_sss.model.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import pe.diegoolipa.api_spring_sss.model.store.Compra;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "id_persona")
    private Integer idPersona;
    private Boolean estado;

    @OneToMany(mappedBy = "cliente")
    private Set<Compra> compras = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private  Persona persona;
}
