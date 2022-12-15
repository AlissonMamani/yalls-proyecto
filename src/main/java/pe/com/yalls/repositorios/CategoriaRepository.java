package pe.com.yalls.repositorios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.yalls.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    @Query("Select c from CategoriaEntity c where c.estado='1'")
    List<Categoria> findAllCustom();
}
