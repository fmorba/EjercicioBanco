/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import modelos.Cliente;
import modelos.Registro;
import modelos.Transferencia;
import repositorios.RepositorioCliente;
import repositorios.RepositorioRegistros;
import repositorios.RepositorioTransferencias;

/**
 *
 * @author Usuario
 */
public class ServicioTransferencia {
    float monto;
    int idOrigen;
    int idDestino;
    Cliente clienteOrigen;
    Cliente clienteDestino;
    Registro registro;
    RepositorioTransferencias repositorioTransferencias;
    RepositorioCliente repositorioCliente;
    RepositorioRegistros repositorioRegistros;
    
    public ServicioTransferencia(){
        this.repositorioTransferencias= new RepositorioTransferencias();
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioRegistros = new RepositorioRegistros();
    }
    
    public void GuardarDatos(String montoIngresado, String identOrigen, String identDestino){
        ValidarDatos(montoIngresado,identOrigen,identDestino);
        
        this.repositorioCliente.ActualizarSaldoCliente(monto, idOrigen, false);
        this.repositorioCliente.ActualizarSaldoCliente(monto, idDestino, true);
        
        Transferencia transferencia = new Transferencia(clienteOrigen,clienteDestino,monto);
        this.repositorioTransferencias.Guardar(transferencia);
        registro = new Registro(clienteOrigen, transferencia, "Envio");
        this.repositorioRegistros.Guardar(registro);
        registro = new Registro(clienteDestino, transferencia, "Recepción");
        this.repositorioRegistros.Guardar(registro);
    }
    
    private void ValidarDatos(String montoEfectivo, String origen, String destino){
        try{
            if (montoEfectivo==null || origen==null || destino==null) {
                throw new NullPointerException ("Campo vacio.");
            }else{
                this.monto = Float.valueOf(montoEfectivo);
                this.idOrigen = Integer.valueOf(origen);
                this.idDestino = Integer.valueOf(destino);
                
                clienteOrigen=repositorioCliente.BuscarPorId(idOrigen);
                clienteDestino=repositorioCliente.BuscarPorId(idDestino);
                
                if (clienteOrigen==null || clienteDestino==null) {
                    throw new NullPointerException ("No existe cliente con dicho ID.");
                }
            }           
        }
        catch(NumberFormatException e){
            throw new NullPointerException ("No ingreso un numero");
        }
    
    }
    
    
    
    
    
}
