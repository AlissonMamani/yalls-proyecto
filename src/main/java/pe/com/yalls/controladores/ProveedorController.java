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
import pe.com.yalls.entidades.Proveedor;
import pe.com.yalls.servicios.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorService servicio;
    
    @GetMapping
    public List<Proveedor> findAll(){
        return servicio.findAll();
    }
    
    
    @GetMapping("/{id}")
    public Optional<Proveedor> findById(@PathVariable Long id){
        
        return servicio.findById(id);
    }
    
    @PostMapping
    public Proveedor add(@RequestBody Proveedor proveedor){
        return servicio.add(proveedor);
    }
    
    @PutMapping("/{id}")
    public Proveedor update(@PathVariable long id, @RequestBody Proveedor proveedor){
        proveedor.setCodigo(id);
        return servicio.update(proveedor);
    }
    
    @DeleteMapping("/{id}")
    public Proveedor delete(@PathVariable long id){
        Proveedor proveedor = new Proveedor();
        proveedor.setEstado(false);
        return servicio.delete(Proveedor.builder().codigo(id).build());
    }
}
