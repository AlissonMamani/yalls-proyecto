package pe.com.jaaldos.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.jaaldos.entidades.EncabezadoBoleta;

public interface EncabezadoBoletaService {
    
    List<EncabezadoBoleta> findAll();

    Optional<EncabezadoBoleta> findById(String id);

    EncabezadoBoleta add(EncabezadoBoleta encabezadoBoleta);

    EncabezadoBoleta update(EncabezadoBoleta encabezadoBoleta);

    EncabezadoBoleta delete(EncabezadoBoleta encabezadoBoleta);
}
