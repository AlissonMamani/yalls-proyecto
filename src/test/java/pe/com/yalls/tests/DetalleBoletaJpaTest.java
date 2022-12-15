
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
import pe.com.yalls.entidades.Cliente;
import pe.com.yalls.entidades.DetalleBoleta;
import pe.com.yalls.entidades.Empleado;
import pe.com.yalls.entidades.EncabezadoBoleta;
import pe.com.yalls.entidades.Producto;
import pe.com.yalls.entidades.Rol;
import pe.com.yalls.repositorios.DetalleBoletaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DetalleBoletaJpaTest {
    
    private static DetalleBoleta objDetalleBoleta;
    private static EncabezadoBoleta objEncabezadoBoleta;
    private static Cliente objCliente;
    private static Empleado objEmpleado;
    private static Rol objRol;
    
    private static Producto objProducto;
    private static Categoria objCategoria;

    @Autowired
    private DetalleBoletaRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objDetalleBoleta = new DetalleBoleta();
        objEncabezadoBoleta = new EncabezadoBoleta();
        objCliente = new Cliente();
        objEmpleado = new Empleado();
        objRol = new Rol();
        objProducto = new Producto();
        objCategoria = new Categoria();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objDetalleBoleta = null;
        objEncabezadoBoleta = null;
        objCliente = null;
        objEmpleado = null;
        objRol = null;
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
        List<DetalleBoleta> detalleBoletas = repositorio.findAll();
        assertNotNull(detalleBoletas);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<DetalleBoleta> detalleBoletas = repositorio.findAllCustom();
        assertNotNull(detalleBoletas);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        Optional<DetalleBoleta> detalleBoleta = repositorio.findById("B0001");
        assertNotNull(detalleBoleta);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        String codigo = "B0003";
        
        objDetalleBoleta.setCodigo(codigo);
        objDetalleBoleta.setItem(1);
        objDetalleBoleta.setImporte(21.5);
        objDetalleBoleta.setEstado(true);
        
        objEncabezadoBoleta.setCodigo(codigo);
        
        objCliente.setCodigo(3);
        objEncabezadoBoleta.setCliente(objCliente);
        
        objRol.setCodigo(2);
        objEmpleado.setCodigo(2);
        objEncabezadoBoleta.setEmpleado(objEmpleado);
        
        objDetalleBoleta.setCodigo_boleta(objEncabezadoBoleta);
        
        objCategoria.setCodigo(3);
        objProducto.setCodigo(3);
        objProducto.setCategoria(objCategoria);
        objDetalleBoleta.setCodigo_producto(objProducto);
        
        DetalleBoleta detalleBoleta = repositorio.save(objDetalleBoleta);
        assertNotNull(detalleBoleta);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        String codigo = "B0001";
        
        objDetalleBoleta.setCodigo(codigo);
        objDetalleBoleta.setItem(1);
        objDetalleBoleta.setImporte(10);
        objDetalleBoleta.setEstado(true);
        
        objEncabezadoBoleta.setCodigo(codigo);
        
        objCliente.setCodigo(1);
        objEncabezadoBoleta.setCliente(objCliente);
        
        objRol.setCodigo(2);
        objEmpleado.setCodigo(2);
        objEncabezadoBoleta.setEmpleado(objEmpleado);
        
        objDetalleBoleta.setCodigo_boleta(objEncabezadoBoleta);
        
        objCategoria.setCodigo(1);
        objProducto.setCodigo(1);
        objProducto.setCategoria(objCategoria);
        objDetalleBoleta.setCodigo_producto(objProducto);
        
        DetalleBoleta detalleBoleta = repositorio.save(objDetalleBoleta);
        assertNotNull(detalleBoleta);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        String codigo = "B0001";
        
        objDetalleBoleta.setCodigo(codigo);
        objDetalleBoleta.setItem(1);
        objDetalleBoleta.setImporte(10);
        objDetalleBoleta.setEstado(false);
        
        objEncabezadoBoleta.setCodigo(codigo);
        
        objCliente.setCodigo(1);
        objEncabezadoBoleta.setCliente(objCliente);
        
        objRol.setCodigo(2);
        objEmpleado.setCodigo(2);
        objEncabezadoBoleta.setEmpleado(objEmpleado);
        
        objDetalleBoleta.setCodigo_boleta(objEncabezadoBoleta);
        
        objCategoria.setCodigo(1);
        objProducto.setCodigo(1);
        objProducto.setCategoria(objCategoria);
        objDetalleBoleta.setCodigo_producto(objProducto);
        
        DetalleBoleta detalleBoleta = repositorio.save(objDetalleBoleta);
        assertNotNull(detalleBoleta);
        System.out.println("@Test --> deleteTest()");
    }
    
}
