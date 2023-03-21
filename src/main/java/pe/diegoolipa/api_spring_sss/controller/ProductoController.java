package pe.diegoolipa.api_spring_sss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.diegoolipa.api_spring_sss.model.Usuario;
import pe.diegoolipa.api_spring_sss.model.store.Producto;
import pe.diegoolipa.api_spring_sss.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

//    @GetMapping("")
//    public List<Producto> index() {
//        return (List<Producto>) productoRepository.findAll();
//    }

    @GetMapping("")
    public List<Producto> findByIdCategoria(int idCategoria) {
        return (List<Producto>) productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(int idProducto){
        productoRepository.deleteById(idProducto);
    }
}
