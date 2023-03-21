package pe.diegoolipa.api_spring_sss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.diegoolipa.api_spring_sss.model.Usuario;
import pe.diegoolipa.api_spring_sss.model.store.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM productos WHERE ID = ?")
    List<Producto> getByProducto(int id);


    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int catidadStock, boolean estado);


}
