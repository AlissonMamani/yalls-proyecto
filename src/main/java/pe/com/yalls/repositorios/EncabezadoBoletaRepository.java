package pe.com.yalls.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.yalls.entidades.EncabezadoBoleta;

public interface EncabezadoBoletaRepository extends JpaRepository<EncabezadoBoleta, String>{
    
}
