package pe.diegoolipa.api_spring_sss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pe.diegoolipa.api_spring_sss.model.store.Compra;
import pe.diegoolipa.api_spring_sss.model.store.Producto;
import pe.diegoolipa.api_spring_sss.repository.CompraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> index(){
        return (List<Compra>) compraRepository.findAll();
    }

    public Optional<Compra> show(int IdCompra){
        return compraRepository.findById(IdCompra);
    }

    public Optional<List<Compra>> getByCliente (int IdCliente){
        return compraRepository.findByIdCliente(IdCliente);
    }

    public Compra save(@RequestBody Compra compra){
        return compraRepository.save(compra);
    }

    public boolean delete(int IdCompra){
        return show(IdCompra).map(producto -> {
            compraRepository.deleteById(IdCompra);
            return true;
        }).orElse(false);
    }
}
