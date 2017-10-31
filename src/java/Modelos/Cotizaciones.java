package Modelos;
// Generated 31-oct-2017 13:16:07 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cotizaciones generated by hbm2java
 */
public class Cotizaciones  implements java.io.Serializable {


     private Integer idCotizacion;
     private Clientes clientes;
     private Empleados empleados;
     private String numero;
     private Date fecha;
     private int descuento;
     private String estado;
     private Set<ProductosCotizaciones> productosCotizacioneses = new HashSet<ProductosCotizaciones>(0);

    public Cotizaciones() {
    }

	
    public Cotizaciones(Clientes clientes, Empleados empleados, String numero, Date fecha, int descuento, String estado) {
        this.clientes = clientes;
        this.empleados = empleados;
        this.numero = numero;
        this.fecha = fecha;
        this.descuento = descuento;
        this.estado = estado;
    }
    public Cotizaciones(Clientes clientes, Empleados empleados, String numero, Date fecha, int descuento, String estado, Set<ProductosCotizaciones> productosCotizacioneses) {
       this.clientes = clientes;
       this.empleados = empleados;
       this.numero = numero;
       this.fecha = fecha;
       this.descuento = descuento;
       this.estado = estado;
       this.productosCotizacioneses = productosCotizacioneses;
    }
   
    public Integer getIdCotizacion() {
        return this.idCotizacion;
    }
    
    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public Empleados getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set<ProductosCotizaciones> getProductosCotizacioneses() {
        return this.productosCotizacioneses;
    }
    
    public void setProductosCotizacioneses(Set<ProductosCotizaciones> productosCotizacioneses) {
        this.productosCotizacioneses = productosCotizacioneses;
    }




}


