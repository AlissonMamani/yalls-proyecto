/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.yalls.controladores;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.yalls.entidades.Rol;
import pe.com.yalls.servicios.RolService;




@RestController
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private RolService servicio;
    
    @GetMapping
    public List<Rol> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Rol> findById(@PathVariable Long id){
        
        return servicio.findById(id);
    }
    
    @PostMapping
    public Rol add(@RequestBody Rol rol){
        return servicio.add(rol);
    }
    
    @PutMapping("/{id}")
    public Rol update(@PathVariable long id, @RequestBody Rol rol){
        rol.setCodigo(id);
        return servicio.update(rol);
    }
    
    @DeleteMapping("/{id}")
    public Rol delete(@PathVariable long id){
        Rol rol = new Rol();
        rol.setEstado(false);
        return servicio.delete(Rol.builder().codigo(id).build());
    }
}
