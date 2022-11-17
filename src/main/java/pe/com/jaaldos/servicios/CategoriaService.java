package pe.com.jaaldos.servicios;

import java.util.List;
import java.util.Optional;
import pe.com.jaaldos.entidades.Categoria;

public interface CategoriaService {
    
    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    Categoria add(Categoria categoria);

    Categoria update(Categoria categoria);

    Categoria delete(Categoria categoria);
}
