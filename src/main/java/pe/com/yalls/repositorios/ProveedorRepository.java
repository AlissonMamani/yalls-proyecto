package pe.com.yalls.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.yalls.entidades.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    @Query("Select pr from Proveedor pr where pr.estado='1'")
    List<Proveedor> findAllCustom();
}
