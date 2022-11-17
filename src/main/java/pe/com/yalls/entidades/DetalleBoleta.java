package pe.com.yalls.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "DetalleBoletaEntity")
@Table(name = "detalle_boleta")
public class DetalleBoleta implements Serializable{
    
    @Column(name = "codigo_boleta")
    @Id
    private String codigo;
    
    @Column(name = "item_producto")
    private int item;
    
    @Column(name = "importe_producto")
    private double importe;
    
    @Column(name = "total_pagar")
    private double total;
    
    @Column(name = "estado_detalle_boleta")
    private boolean estado; 
    
    @ManyToOne
    @JoinColumn(name = "codigo_boleta", nullable = false, insertable = false, updatable = false)
    private EncabezadoBoleta codigo_boleta; 
    
    @ManyToOne
    @JoinColumn(name = "codigo_producto", nullable = false)
    private Producto codigo_producto; 
}
