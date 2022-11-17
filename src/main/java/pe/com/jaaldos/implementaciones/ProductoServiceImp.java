package pe.com.jaaldos.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.jaaldos.entidades.Producto;
import pe.com.jaaldos.repositorios.ProductoRepository;
import pe.com.jaaldos.servicios.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    private ProductoRepository repositorio;
    
    @Override
    public List<Producto> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Producto add(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        Producto p = repositorio.getById(producto.getCodigo());
        BeanUtils.copyProperties(producto, p);
        return repositorio.save(p);
    }

    @Override
    public Producto delete(Producto producto) {
        Producto p = repositorio.getById(producto.getCodigo());
        p.setEstado(false);
        return repositorio.save(p);
    }
    
    
}
