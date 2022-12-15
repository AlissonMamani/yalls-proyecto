
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
import pe.com.yalls.entidades.Cliente;
import pe.com.yalls.repositorios.ClienteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClienteJpaTest {
    
    private static Cliente objcliente;

    @Autowired
    private ClienteRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objcliente = new Cliente();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objcliente = null;
        System.out.println("@AfterAll --> Final");
    }

    @Test
    public void Mensaje() {
        System.out.println("Prueba Inicial");
        System.out.println("@Test --> PruebaInicial");
    }

    @Test
    public void findAllTest() {
        List<Cliente> clientes = repositorio.findAll();
        assertNotNull(clientes);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<Cliente> clientes = repositorio.findAllCustom();
        assertNotNull(clientes);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        long id = 1;
        Optional<Cliente> cliente = repositorio.findById(id);
        assertNotNull(cliente);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        objcliente.setNombres("Bryan Ernesto");
        objcliente.setApellido_paterno("Caceres");
        objcliente.setApellido_materno("Delgado");
        objcliente.setGenero("Masculino");
        objcliente.setCorreo("bryancaceres@gmail.com");
        objcliente.setFecha_nacimiento("02/02/2002");
        objcliente.setEstado(true);
        
        Cliente cliente = repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        objcliente.setCodigo(1);
        objcliente.setNombres("Marco Antonio Actualizado");
        objcliente.setApellido_paterno("Garay Actualizado");
        objcliente.setApellido_materno("Valladolid Actualizado");
        objcliente.setGenero("Masculino");
        objcliente.setCorreo("marcogvnuevo@gmail.com");
        objcliente.setFecha_nacimiento("17/08/2002");
        objcliente.setEstado(true);
        
        Cliente cliente = repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        objcliente.setCodigo(1);
        objcliente.setNombres("Marco Antonio Actualizado");
        objcliente.setApellido_paterno("Garay Actualizado");
        objcliente.setApellido_materno("Valladolid Actualizado");
        objcliente.setGenero("Masculino");
        objcliente.setCorreo("marcogvnuevo@gmail.com");
        objcliente.setFecha_nacimiento("17/08/2002");
        objcliente.setEstado(false);
        
        Cliente cliente = repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test --> deleteTest()");
    }
}
