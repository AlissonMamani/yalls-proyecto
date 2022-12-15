
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
import pe.com.yalls.entidades.Empleado;
import pe.com.yalls.entidades.EncabezadoBoleta;
import pe.com.yalls.entidades.Rol;
import pe.com.yalls.repositorios.EncabezadoBoletaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EncabezadoBoletaJpaTest {
    
    private static EncabezadoBoleta objEncabezadoBoleta;
    private static Cliente objCliente;
    private static Empleado objEmpleado;
    private static Rol objRol;

    @Autowired
    private EncabezadoBoletaRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objEncabezadoBoleta = new EncabezadoBoleta();
        objCliente = new Cliente();
        objEmpleado = new Empleado();
        objRol = new Rol();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objEncabezadoBoleta = null;
        objCliente = null;
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
        List<EncabezadoBoleta> encabezadoBoletas = repositorio.findAll();
        assertNotNull(encabezadoBoletas);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<EncabezadoBoleta> encabezadoBoletas = repositorio.findAllCustom();
        assertNotNull(encabezadoBoletas);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        Optional<EncabezadoBoleta> encabezadoBoleta = repositorio.findById("B0001");
        assertNotNull(encabezadoBoleta);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        objEncabezadoBoleta.setCodigo("B0004");
        objEncabezadoBoleta.setFecha("15/12/2022");
        objEncabezadoBoleta.setEstado(true);
        
        objCliente.setCodigo(1);
        objEncabezadoBoleta.setCliente(objCliente);
        
        objRol.setCodigo(2);
        objEmpleado.setCodigo(2);
        objEncabezadoBoleta.setEmpleado(objEmpleado);
        
        EncabezadoBoleta encabezadoBoleta = repositorio.save(objEncabezadoBoleta);
        assertNotNull(encabezadoBoleta);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        objEncabezadoBoleta.setCodigo("B0001");
        objEncabezadoBoleta.setFecha("15/12/2022");
        objEncabezadoBoleta.setEstado(true);
        
        objCliente.setCodigo(1);
        objEncabezadoBoleta.setCliente(objCliente);
        
        objRol.setCodigo(2);
        objEmpleado.setCodigo(2);
        objEncabezadoBoleta.setEmpleado(objEmpleado);
        
        EncabezadoBoleta encabezadoBoleta = repositorio.save(objEncabezadoBoleta);
        assertNotNull(encabezadoBoleta);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        objEncabezadoBoleta.setCodigo("B0001");
        objEncabezadoBoleta.setFecha("15/12/2022");
        objEncabezadoBoleta.setEstado(false);
        
        objCliente.setCodigo(1);
        objEncabezadoBoleta.setCliente(objCliente);
        
        objRol.setCodigo(2);
        objEmpleado.setCodigo(2);
        objEncabezadoBoleta.setEmpleado(objEmpleado);
        
        EncabezadoBoleta encabezadoBoleta = repositorio.save(objEncabezadoBoleta);
        assertNotNull(encabezadoBoleta);
        System.out.println("@Test --> deleteTest()");
    }
    
}
