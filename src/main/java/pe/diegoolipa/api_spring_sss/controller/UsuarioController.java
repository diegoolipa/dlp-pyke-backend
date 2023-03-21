package pe.diegoolipa.api_spring_sss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.diegoolipa.api_spring_sss.model.Usuario;
import pe.diegoolipa.api_spring_sss.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("")
    public List<Usuario> index() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @PostMapping
    Usuario crear(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("{id}")
    List<Usuario> getByUsuario(@PathVariable Integer id) {
        return usuarioRepository.getByUsuario(id);
    }

    @PutMapping(value = "{id:[0-9]+}")
    Usuario actualizarTo(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id).get();
        usuarioEncontrado.setNombres(usuario.getNombres());
        usuarioEncontrado.setApellidos(usuario.getApellidos());
        usuarioEncontrado.setCorreo_electronico(usuario.getCorreo_electronico());
        return usuarioRepository.save(usuarioEncontrado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void eliminar(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }
}
