package pe.com.yalls.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.yalls.entidades.EncabezadoBoleta;

public interface EncabezadoBoletaService {
    
    List<EncabezadoBoleta> findAll();
    
    List<EncabezadoBoleta> findAllCustom();

    Optional<EncabezadoBoleta> findById(String id);

    EncabezadoBoleta add(EncabezadoBoleta encabezadoBoleta);

    EncabezadoBoleta update(EncabezadoBoleta encabezadoBoleta);

    EncabezadoBoleta delete(EncabezadoBoleta encabezadoBoleta);
}
