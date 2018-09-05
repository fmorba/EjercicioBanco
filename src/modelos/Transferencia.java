/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Usuario
 */
public class Transferencia {
    private int cantidad;
    private Cliente origen;
    private Cliente destino;

    public Transferencia(int cantidad, Cliente origen, Cliente destino) {
        this.cantidad = cantidad;
        this.origen = origen;
        this.destino = destino;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Cliente getOrigen() {
        return origen;
    }

    public Cliente getDestino() {
        return destino;
    }
    
    
}
