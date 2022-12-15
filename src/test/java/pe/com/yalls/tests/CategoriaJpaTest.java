/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import pe.com.yalls.repositorios.CategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoriaJpaTest {
    
    private static Categoria objcategoria;

    @Autowired
    private CategoriaRepository repositorio;

    @BeforeAll
    public static void Inicio() {
        objcategoria = new Categoria();
        System.out.println("@BeforeAll --> Inicio");
    }

    @AfterAll
    public static void Final() {
        objcategoria = null;
        System.out.println("@AfterAll --> Final");
    }

    @Test
    public void Mensaje() {
        System.out.println("Prueba Inicial");
        System.out.println("@Test --> PruebaInicial");
    }

    @Test
    public void findAllTest() {
        List<Categoria> categoria = repositorio.findAll();
        assertNotNull(categoria);
        System.out.println("@Test --> findAllTest()");
    }

    @Test
    public void findAllCustomTest() {
        List<Categoria> categoria = repositorio.findAllCustom();
        assertNotNull(categoria);
        System.out.println("@Test --> findAllCustomTest()");
    }

    @Test
    public void findByIdTest() {
        long id = 1;
        Optional<Categoria> categoria = repositorio.findById(id);
        assertNotNull(categoria);
        System.out.println("@Test --> findByIdTest()");
    }

    @Test
    @Rollback(false)
    public void addTest() {
        objcategoria.setNombre("Jabones");
        objcategoria.setEstado(true);
        Categoria categoria = repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("@Test --> addTest()");
    }

    @Test
    @Rollback(false)
    public void updateTest() {
        objcategoria.setCodigo(1);
        objcategoria.setNombre("Pastillas Actualizado");
        objcategoria.setEstado(true);
        Categoria categoria = repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("@Test --> updateTest()");
    }

    @Test
    @Rollback(false)
    public void deleteTest() {
        objcategoria.setCodigo(1);
        objcategoria.setNombre("Pastillas Actualizado");
        objcategoria.setEstado(false);
        Categoria categoria = repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("@Test --> deleteTest()");
    }
}
