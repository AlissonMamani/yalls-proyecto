package pe.com.yalls.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.yalls.entidades.Producto;

public interface ProductoService {
    
    List<Producto> findAll();
    
    List<Producto> findAllCustom();

    Optional<Producto> findById(Long id);

    Producto add(Producto producto);

    Producto update(Producto producto);

    Producto delete(Producto producto);
}
