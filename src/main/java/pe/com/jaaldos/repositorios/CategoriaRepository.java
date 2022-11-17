package pe.com.jaaldos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jaaldos.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
