package modelos;
// Generated 05/09/2018 14:24:47 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Transferencia generated by hbm2java
 */
public class Transferencia  implements java.io.Serializable {


     private Integer idTransferencia;
     private Cliente clienteByOrigen;
     private Cliente clienteByDestino;
     private float cantidad;
     private Set registros = new HashSet(0);

    public Transferencia() {
    }

	
    public Transferencia(Cliente clienteByOrigen, Cliente clienteByDestino, float cantidad) {
        this.clienteByOrigen = clienteByOrigen;
        this.clienteByDestino = clienteByDestino;
        this.cantidad = cantidad;
    }
    public Transferencia(Cliente clienteByOrigen, Cliente clienteByDestino, float cantidad, Set registros) {
       this.clienteByOrigen = clienteByOrigen;
       this.clienteByDestino = clienteByDestino;
       this.cantidad = cantidad;
       this.registros = registros;
    }
   
    public Integer getIdTransferencia() {
        return this.idTransferencia;
    }
    
    public void setIdTransferencia(Integer idTransferencia) {
        this.idTransferencia = idTransferencia;
    }
    public Cliente getClienteByOrigen() {
        return this.clienteByOrigen;
    }
    
    public void setClienteByOrigen(Cliente clienteByOrigen) {
        this.clienteByOrigen = clienteByOrigen;
    }
    public Cliente getClienteByDestino() {
        return this.clienteByDestino;
    }
    
    public void setClienteByDestino(Cliente clienteByDestino) {
        this.clienteByDestino = clienteByDestino;
    }
    public float getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public Set getRegistros() {
        return this.registros;
    }
    
    public void setRegistros(Set registros) {
        this.registros = registros;
    }




}


