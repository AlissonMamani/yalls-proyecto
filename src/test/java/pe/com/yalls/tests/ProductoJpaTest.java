
package pe.com.yalls.tests;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pe.com.yalls.entidades.Categoria;
import pe.com.yalls.entidades.Producto;
import pe.com.yalls.repositorios.ProductoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductoJpaTest {
    
    private static Producto objProducto;
    private static Categoria objCategoria;

    @Autowired
    private ProductoRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objProducto = new Producto();
        objCategoria = new Categoria();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objProducto = null;
        objCategoria = null;
        System.out.println("@AfterAll --> Final");
    }

    @Test
    public void Mensaje() {
        System.out.println("Prueba Inicial");
        System.out.println("@Test --> PruebaInicial");
    }

    @Test
    public void findAllTest() {
        List<Producto> productos = repositorio.findAll();
        assertNotNull(productos);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<Producto> productos = repositorio.findAllCustom();
        assertNotNull(productos);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        long id = 1;
        Optional<Producto> producto = repositorio.findById(id);
        assertNotNull(producto);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        objProducto.setNombre("Panadol Forte");
        objProducto.setPrecio(2.5);
        objProducto.setStock(200);
        objProducto.setEstado(true);
        
        objCategoria.setCodigo(1);
        objProducto.setCategoria(objCategoria);
        
        Producto producto = repositorio.save(objProducto);
        assertNotNull(producto);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        objProducto.setCodigo(1);
        objProducto.setNombre("Paracetamol Actualizado");
        objProducto.setPrecio(5);
        objProducto.setStock(150);
        objProducto.setEstado(true);
        
        objCategoria.setCodigo(1);
        objProducto.setCategoria(objCategoria);
        
        Producto producto = repositorio.save(objProducto);
        assertNotNull(producto);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        objProducto.setCodigo(1);
        objProducto.setNombre("Paracetamol Actualizado");
        objProducto.setPrecio(5);
        objProducto.setStock(150);
        objProducto.setEstado(false);
        
        objCategoria.setCodigo(1);
        objProducto.setCategoria(objCategoria);
        
        Producto producto = repositorio.save(objProducto);
        assertNotNull(producto);
        System.out.println("@Test --> deleteTest()");
    }
    
}

