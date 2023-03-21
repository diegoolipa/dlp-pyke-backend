package pe.diegoolipa.api_spring_sss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.diegoolipa.api_spring_sss.model.Libro;
import pe.diegoolipa.api_spring_sss.model.Usuario;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    @Query(value = "SELECT * FROM LIBRO WHERE ID = ?", nativeQuery = true)
    List<Libro> getByLibro(int id);
}
