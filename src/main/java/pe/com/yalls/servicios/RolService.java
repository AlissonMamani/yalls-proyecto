/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.yalls.servicios;



import java.util.List;
import java.util.Optional;
import pe.com.yalls.entidades.Rol;



public interface RolService {
    
    List<Rol> findAll();



   Optional<Rol> findById(Long id);



   Rol add(Rol rol);



   Rol update(Rol rol);



   Rol delete(Rol rol);
    
}
