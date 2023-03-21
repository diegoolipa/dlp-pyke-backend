package pe.diegoolipa.api_spring_sss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.diegoolipa.api_spring_sss.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM USUARIO WHERE ID = ?")
    List<Usuario> getByUsuario(int id);
}
