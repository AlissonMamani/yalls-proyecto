package pe.com.jaaldos.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.jaaldos.entidades.Proveedor;

public interface ProveedorService {
    
    List<Proveedor> findAll();

    Optional<Proveedor> findById(Long id);

    Proveedor add(Proveedor proveedor);

    Proveedor update(Proveedor proveedor);

    Proveedor delete(Proveedor proveedor);
}
