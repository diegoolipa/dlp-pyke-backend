package pe.diegoolipa.api_spring_sss.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.diegoolipa.api_spring_sss.model.Usuario;
import pe.diegoolipa.api_spring_sss.model.store.Producto;
import pe.diegoolipa.api_spring_sss.repository.ProductoRepository;
import pe.diegoolipa.api_spring_sss.service.ProductoService;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Autowired
    private ProductoService productoService;


    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAll() {
        return new ResponseEntity<>(productoService.getAll(),HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Producto> getProducto(@PathVariable("id") int idProducto) {
//        System.out.println(">>>>>>>>>>>>>>>>" + idProducto);
//        return productoRepository.findById(idProducto)
//                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping("/categoria/{id}")
//    public ResponseEntity<List<Producto>> findByIdCategoria(@PathVariable("id") int idCategoria) {
//        return productoService.getByCategory(idCategoria)
//                .map(productos -> new ResponseEntity<>(productos, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//
//    @PostMapping("/save")
//    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
//        System.out.println(">>>>>>>>>>>>>>>>" + producto);
//        return new ResponseEntity<>(productoRepository.save(producto), HttpStatus.CREATED);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable("id") int idProducto) {
//        if (productoService.delete(idProducto)){
//            return new ResponseEntity(HttpStatus.OK);
//        }else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }
}
