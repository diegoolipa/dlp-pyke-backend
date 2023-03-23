package pe.diegoolipa.api_spring_sss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.diegoolipa.api_spring_sss.model.store.Producto;
import pe.diegoolipa.api_spring_sss.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoRepository.findAll();
    }

    public Optional<Producto> getProducto(int IdProducto){
        return productoRepository.findById(IdProducto);
    }

    public List<Producto> getByProducto (int IdProducto){
        return productoRepository.getByProducto(IdProducto);
    }

    public Optional<List<Producto>> getByCategory(int IdCategoria){
        return Optional.ofNullable(productoRepository.findByIdCategoriaOrderByNombreAsc(IdCategoria));
    }

    public boolean delete(int IdProducto){
        return getProducto(IdProducto).map(producto -> {
            productoRepository.deleteById(IdProducto);
            return true;
        }).orElse(false);
    }

}
