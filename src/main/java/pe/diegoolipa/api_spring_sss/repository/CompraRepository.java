package pe.diegoolipa.api_spring_sss.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.diegoolipa.api_spring_sss.model.store.Compra;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(int IdCliente);
}
