package pe.com.yalls.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.yalls.entidades.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
    
}
