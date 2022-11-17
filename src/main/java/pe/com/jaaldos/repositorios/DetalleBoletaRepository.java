package pe.com.jaaldos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jaaldos.entidades.DetalleBoleta;

public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, String>{
    
}
