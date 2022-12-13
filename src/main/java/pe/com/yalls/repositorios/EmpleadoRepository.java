package pe.com.yalls.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.yalls.entidades.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}
