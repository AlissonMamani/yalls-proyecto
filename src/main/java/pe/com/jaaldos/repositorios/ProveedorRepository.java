package pe.com.jaaldos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jaaldos.entidades.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}
