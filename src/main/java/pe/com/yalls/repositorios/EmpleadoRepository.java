package pe.com.yalls.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.yalls.entidades.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    @Query("Select e from EmpleadoEntity e where e.estado='1'")
    List<Empleado> findAllCustom();
}
