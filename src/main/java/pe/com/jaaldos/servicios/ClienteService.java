package pe.com.jaaldos.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.jaaldos.entidades.Cliente;

public interface ClienteService {
    
    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente add(Cliente cliente);

    Cliente update(Cliente categoria);

    Cliente delete(Cliente categoria);
}
