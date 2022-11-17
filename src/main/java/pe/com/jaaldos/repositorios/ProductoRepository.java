package pe.com.jaaldos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jaaldos.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
