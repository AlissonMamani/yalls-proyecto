package pe.com.yalls.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.yalls.entidades.Proveedor;

public interface ProveedorService {
    
    List<Proveedor> findAll();
    
    List<Proveedor> findAllCustom();

    Optional<Proveedor> findById(Long id);

    Proveedor add(Proveedor proveedor);

    Proveedor update(Proveedor proveedor);

    Proveedor delete(Proveedor proveedor);
}
