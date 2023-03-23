package pe.diegoolipa.api_spring_sss.model.store;

import jakarta.persistence.*;
import lombok.Data;
import pe.diegoolipa.api_spring_sss.model.person.Cliente;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private Integer idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    //RECUEPRAR LA INFORMACION DEL QUE ESTA HACIENDO LA COMPRA
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //TODA LA LISTA DE PRODUCTOS QUE PERTENECE A UNA COMPRA
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private Set<ComprasProducto> productos;

}
