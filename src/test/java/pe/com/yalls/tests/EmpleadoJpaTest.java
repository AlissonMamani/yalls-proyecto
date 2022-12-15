
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
import pe.com.yalls.entidades.Empleado;
import pe.com.yalls.entidades.Rol;
import pe.com.yalls.repositorios.EmpleadoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmpleadoJpaTest {
    
    private static Empleado objEmpleado;
    private static Rol objRol;

    @Autowired
    private EmpleadoRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objEmpleado = new Empleado();
        objRol = new Rol();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objEmpleado = null;
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
        List<Empleado> empleados = repositorio.findAll();
        assertNotNull(empleados);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<Empleado> empleados = repositorio.findAllCustom();
        assertNotNull(empleados);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        long id = 1;
        Optional<Empleado> empleado = repositorio.findById(id);
        assertNotNull(empleado);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        objEmpleado.setNombres("Robert");
        objEmpleado.setApellido_paterno("Pickering");
        objEmpleado.setApellido_materno("Burnham");
        objEmpleado.setGenero("Masculino");
        objEmpleado.setCorreo("boburnham@gmail.com");
        objEmpleado.setFecha_nacimiento("21/08/1990");
        objEmpleado.setEstado(true);
        
        objRol.setCodigo(1);
        objEmpleado.setRol(objRol);
        
        Empleado empleado = repositorio.save(objEmpleado);
        assertNotNull(empleado);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        objEmpleado.setCodigo(1);
        objEmpleado.setNombres("Alisson Araceli Actualizado");
        objEmpleado.setApellido_paterno("Mamani Actualizado");
        objEmpleado.setApellido_materno("Benavente Actualizado");
        objEmpleado.setGenero("Femenino");
        objEmpleado.setCorreo("alissonaraceli@gmail.com");
        objEmpleado.setFecha_nacimiento("20/04/2004");
        objEmpleado.setEstado(true);
        
        objRol.setCodigo(2);
        objEmpleado.setRol(objRol);
        
        Empleado empleado = repositorio.save(objEmpleado);
        assertNotNull(empleado);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        objEmpleado.setCodigo(1);
        objEmpleado.setNombres("Alisson Araceli Actualizado");
        objEmpleado.setApellido_paterno("Mamani Actualizado");
        objEmpleado.setApellido_materno("Benavente Actualizado");
        objEmpleado.setGenero("Femenino");
        objEmpleado.setCorreo("alissonaraceli@gmail.com");
        objEmpleado.setFecha_nacimiento("20/04/2004");
        objEmpleado.setEstado(false);
        
        objRol.setCodigo(2);
        objEmpleado.setRol(objRol);
        
        Empleado empleado = repositorio.save(objEmpleado);
        assertNotNull(empleado);
        System.out.println("@Test --> deleteTest()");
    }
}
