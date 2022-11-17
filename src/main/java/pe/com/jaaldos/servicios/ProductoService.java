package pe.com.jaaldos.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.jaaldos.entidades.Producto;

public interface ProductoService {
    
    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    Producto add(Producto producto);

    Producto update(Producto producto);

    Producto delete(Producto producto);
}
