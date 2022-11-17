package pe.com.jaaldos.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.jaaldos.entidades.DetalleBoleta;

public interface DetalleBoletaService {
    
    List<DetalleBoleta> findAll();

    Optional<DetalleBoleta> findById(String id);

    DetalleBoleta add(DetalleBoleta detalleBoleta);

    DetalleBoleta update(DetalleBoleta detalleBoleta);

    DetalleBoleta delete(DetalleBoleta detalleBoleta);
}
