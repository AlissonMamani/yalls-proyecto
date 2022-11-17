package pe.com.yalls.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")
public class Proveedor implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codigo_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name = "nombre_proveedor")
    private String nombre;
    
    @Column(name = "estado_proveedor")
    private boolean estado;    
}
