package pe.com.yalls.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.yalls.entidades.DetalleBoleta;

public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, String>{
    @Query("Select db from DetalleBoleta db where db.estado='1'")
    List<DetalleBoleta> findAllCustom();
}
