package pe.com.yalls.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.yalls.entidades.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
    @Query("Select c from Cliente c where c.estado='1'")
    List<Cliente> findAllCustom();
    
}
