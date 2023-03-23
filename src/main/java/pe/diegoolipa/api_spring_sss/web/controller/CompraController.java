package pe.diegoolipa.api_spring_sss.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.diegoolipa.api_spring_sss.model.store.Compra;
import pe.diegoolipa.api_spring_sss.service.CompraService;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

//    public CompraController(CompraService compraService) {
//        this.compraService = compraService;
//    }

    @GetMapping("")
    public ResponseEntity<List<Compra>> getAll() {
        return new ResponseEntity<>(compraService.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getProducto(@PathVariable("id") int IdCompra) {
        return compraService.show(IdCompra)
                .map(compras -> new ResponseEntity<>(compras, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<List<Compra>> getByCliente(@PathVariable("id") int IdCliente){
        return compraService.getByCliente(IdCliente)
                .map(compras -> new ResponseEntity<>(compras,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Compra> save(@RequestBody Compra compra) {
        return new ResponseEntity<>(compraService.save(compra), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int IdCompra) {
        if (compraService.delete(IdCompra)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
//Diego