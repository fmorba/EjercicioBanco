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
public class Cliente {
    static int contador=0;
    int id;
    String nombre;
    String apellido;
    String dni;
    float saldoInicial;
    float saldoActual;

    public Cliente(String nombre, String apellido, String dni, float saldo) {
        contador+=1;
        id=contador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.saldoInicial = saldo;
        this.saldoActual=saldo;
    }

    public int getId() {
        return id;
    }
       
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    
       
    
}
