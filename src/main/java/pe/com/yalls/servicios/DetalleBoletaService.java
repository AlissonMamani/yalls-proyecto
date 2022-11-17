package pe.com.yalls.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.yalls.entidades.DetalleBoleta;

public interface DetalleBoletaService {
    
    List<DetalleBoleta> findAll();
    
    List<DetalleBoleta> findAllCustom();

    Optional<DetalleBoleta> findById(String id);

    DetalleBoleta add(DetalleBoleta detalleBoleta);

    DetalleBoleta update(DetalleBoleta detalleBoleta);

    DetalleBoleta delete(DetalleBoleta detalleBoleta);
}
