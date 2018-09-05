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
public class Registro {
    private Cliente cliente;
    private Transferencia transferencia;
    private String tipo;
    private float estadoSaldoInicio;
    private float estadoSaldoFinal;

    public Registro(Cliente cliente, Transferencia transferencia, String Tipo) {
        this.cliente = cliente;
        this.transferencia = transferencia;
        this.tipo = Tipo;
        if (Tipo.equals("Envio")) {
           this.estadoSaldoInicio=cliente.getSaldoActual()+transferencia.getCantidad();
           this.estadoSaldoFinal=cliente.getSaldoActual();
        }else{
           this.estadoSaldoInicio=cliente.getSaldoActual()-transferencia.getCantidad();
           this.estadoSaldoFinal=cliente.getSaldoActual();
        }
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public String getTipo() {
        return tipo;
    }

    public float getEstadoSaldoInicio() {
        return estadoSaldoInicio;
    }

    public float getEstadoSaldoFinal() {
        return estadoSaldoFinal;
    }

    
    
}
