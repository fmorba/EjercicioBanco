/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import modelos.Cliente;
import repositorios.RepositorioCliente;

/**
 *
 * @author Usuario
 */
public class ServicioCliente {
    String nombreCliente;
    String apellidoCliente;
    String dniCliente;
    float saldoCliente;
    RepositorioCliente repositorioCliente;
    
    public ServicioCliente(){
        this.repositorioCliente= new RepositorioCliente();
    }
    
    public void GuardarDatos(String nombre, String apellido, String dni, String saldo){
        this.ValidarDatos(nombre, apellido, dni, saldo);
        
        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, dniCliente, saldoCliente);
        this.repositorioCliente.Guardar(cliente);
    }
    
    private void ValidarDatos(String nombre, String apellido, String dni, String saldo){
        
        if (nombre==null) {
            throw new IllegalArgumentException("El campo nombre esta vacio.");
        } else {
            this.nombreCliente = nombre;
        }
         
        if (apellido==null) {
            throw new IllegalArgumentException("El campo apellido esta vacio.");
        } else {
            this.apellidoCliente = apellido;
        }
         
        if (dni==null) {
            throw new IllegalArgumentException("El campo dni esta vacio.");
        } else {
            try {
                
                int dniprueba = Integer.valueOf(dni);
                
                if (dni.length()>7 && dni.length()<9) {
                    this.dniCliente = dni;
                }else{
                    throw new IllegalArgumentException("El dni ingresado no tiene el formato correcto.");
            
                }               
                
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en el caampo Dni.");
            }
            
        } 
         
         if (saldo==null) {
            throw new IllegalArgumentException("El campo saldo esta vacio.");
        } else {
             try {
                 
                 float saldoConvertido = Float.valueOf(saldo);
                 this.saldoCliente = saldoConvertido;
        
             } catch (NumberFormatException e) {
                 throw new IllegalArgumentException("El dato ingresado no es un numero.");
             }
         }    
    }

    

}
