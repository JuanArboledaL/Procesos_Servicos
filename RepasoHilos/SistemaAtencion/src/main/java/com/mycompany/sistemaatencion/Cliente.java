/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaatencion;

/**
 *
 * @author juana
 */
public class Cliente implements Runnable{
    
    private final String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " está esperando atención...");
            Thread.sleep(1000); // Simula el tiempo que pasa esperando
        } catch (InterruptedException e) {
            System.err.println("Error en el cliente " + nombre + ": " + e.getMessage());
        }
    }
}
