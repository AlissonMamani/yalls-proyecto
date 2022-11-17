package pe.com.yalls.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.yalls.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
