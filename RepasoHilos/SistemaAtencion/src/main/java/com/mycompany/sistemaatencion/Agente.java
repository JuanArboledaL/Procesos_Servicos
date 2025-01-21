/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaatencion;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author juana
 */
public class Agente implements Runnable{
    
    private final String nombre;
    private final BlockingQueue<Cliente> colaClientes;

    public Agente(String nombre, BlockingQueue<Cliente> colaClientes) {
        this.nombre = nombre;
        this.colaClientes = colaClientes;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Tomar un cliente de la cola (bloquea si está vacía)
                Cliente cliente = colaClientes.take();
                System.out.println(nombre + " está atendiendo a " + cliente.getNombre());

                // Simular el tiempo de atención
                Thread.sleep((int) (Math.random() * 2000) + 1000);

                System.out.println(nombre + " ha terminado de atender a " + cliente.getNombre());
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido.");
                break; // Finalizar el hilo si es interrumpido
            }
        }
    }
}
