package pe.diegoolipa.api_spring_sss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.diegoolipa.api_spring_sss.model.Libro;
import pe.diegoolipa.api_spring_sss.model.Usuario;
import pe.diegoolipa.api_spring_sss.repository.LibroRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping("")
    List<Libro> index(){
        return (List<Libro>) libroRepository.findAll();
    }

    @GetMapping("{id}")
    List<Libro> getByLibro(@PathVariable Integer id) {
        return libroRepository.getByLibro(id);
    }

    @PostMapping
    Libro crear(@RequestBody Libro libro){
        return libroRepository.save(libro);
    }

    @PutMapping("{id}")
    Libro actualizar(@PathVariable Integer id, @RequestBody Libro libro){
        Libro libroFronDb = libroRepository.getById(id);
        libroFronDb.setTitulo(libro.getTitulo());
        libroFronDb.setPrecio(libro.getPrecio());
        return libroRepository.save(libroFronDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("{id}")
    void eliminar(@PathVariable Integer id){
        Libro libro = libroRepository.getById(id);
        libroRepository.delete(libro);
    }
}
