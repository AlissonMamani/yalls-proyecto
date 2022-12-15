
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
import pe.com.yalls.entidades.Rol;
import pe.com.yalls.repositorios.RolRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RolJpaTest {

    private static Rol objRol;

    @Autowired
    private RolRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objRol = new Rol();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objRol = null;
        System.out.println("@AfterAll --> Final");
    }

    @Test
    public void Mensaje() {
        System.out.println("Prueba Inicial");
        System.out.println("@Test --> PruebaInicial");
    }

    @Test
    public void findAllTest() {
        List<Rol> roles = repositorio.findAll();
        assertNotNull(roles);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<Rol> roles = repositorio.findAllCustom();
        assertNotNull(roles);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        long id = 1;
        Optional<Rol> rol = repositorio.findById(id);
        assertNotNull(rol);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        objRol.setNombre("Supervisor");
        objRol.setEstado(true);
        Rol rol = repositorio.save(objRol);
        assertNotNull(rol);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        objRol.setCodigo(1);
        objRol.setNombre("Administrador del Sistema Actualizado");
        objRol.setEstado(true);
        Rol rol = repositorio.save(objRol);
        assertNotNull(rol);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        objRol.setCodigo(1);
        objRol.setNombre("Administrador del Sistema Actualizado");
        objRol.setEstado(false);
        Rol rol = repositorio.save(objRol);
        assertNotNull(rol);
        System.out.println("@Test --> deleteTest()");
    }
}
