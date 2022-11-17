package pe.com.jaaldos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jaaldos.entidades.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
    
}
