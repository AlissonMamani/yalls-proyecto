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
import pe.com.yalls.entidades.DetalleBoleta;
import pe.com.yalls.servicios.DetalleBoletaService;

@RestController
@RequestMapping("/detalle-boleta")
public class DetalleBoletaController {
    
    @Autowired
    private DetalleBoletaService servicio;
    
    @GetMapping
    public List<DetalleBoleta> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<DetalleBoleta> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<DetalleBoleta> findById(@PathVariable String id){
        
        return servicio.findById(id);
    }
    
    @PostMapping
    public DetalleBoleta add(@RequestBody DetalleBoleta detalleBoleta){
        return servicio.add(detalleBoleta);
    }
    
    @PutMapping("/{id}")
    public DetalleBoleta update(@PathVariable String id, @RequestBody DetalleBoleta detalleBoleta){
        detalleBoleta.setCodigo(id);
        return servicio.update(detalleBoleta);
    }
    
    @DeleteMapping("/{id}")
    public DetalleBoleta delete(@PathVariable String id){
        DetalleBoleta detalleBoleta = new DetalleBoleta();
        detalleBoleta.setEstado(false);
        return servicio.delete(DetalleBoleta.builder().codigo(id).build());
    }
}
