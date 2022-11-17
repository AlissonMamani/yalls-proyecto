package pe.com.yalls.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.yalls.entidades.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}
