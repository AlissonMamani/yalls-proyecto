/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.yalls.implementaciones;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yalls.entidades.Rol;
import pe.com.yalls.repositorios.RolRepository;
import pe.com.yalls.servicios.RolService;



@Service
public class RolServiceImp implements RolService{
    
    @Autowired
    private RolRepository repositorio;
    
    @Override
    public List<Rol> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Rol> findAllCustom() {
        return repositorio.findAllCustom();
    }

   @Override
    public Optional<Rol> findById(Long id) {
        return repositorio.findById(id);
    }



   @Override
    public Rol add(Rol rol) {
        return repositorio.save(rol);
    }



   @Override
    public Rol update(Rol rol) {
        Rol nuevo_rol = repositorio.getById(rol.getCodigo());
        BeanUtils.copyProperties(rol, nuevo_rol);
        return repositorio.save(nuevo_rol);
    }



   @Override
    public Rol delete(Rol rol) {
        Rol nuevo_rol = repositorio.getById(rol.getCodigo());
        nuevo_rol.setEstado(false);
        return repositorio.save(nuevo_rol);
    }
}
