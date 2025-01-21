/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistemaatencion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author juana
 */
public class SistemaAtencion {

    public static void main(String[] args) {
        // Cola de clientes con capacidad máxima de 10
        BlockingQueue<Cliente> colaClientes = new ArrayBlockingQueue<>(10);

        // Crear y lanzar agentes (3 en este caso)
        Thread agente1 = new Thread(new Agente("Agente 1", colaClientes));
        Thread agente2 = new Thread(new Agente("Agente 2", colaClientes));
        Thread agente3 = new Thread(new Agente("Agente 3", colaClientes));

        agente1.start();
        agente2.start();
        agente3.start();

        // Crear y añadir clientes a la cola
        for (int i = 1; i <= 20; i++) {
            Cliente cliente = new Cliente("Cliente " + i);
            try {
                colaClientes.put(cliente); // Bloquea si la cola está llena
                System.out.println(cliente.getNombre() + " se ha añadido a la cola.");
            } catch (Exception e) {
                System.err.println("Error al añadir cliente a la cola: " + e.getMessage());
            }
        }

        // Detener agentes una vez que todos los clientes hayan sido atendidos
        try {
            Thread.sleep(10000); // Esperar tiempo suficiente para procesar todos los clientes
        } catch (InterruptedException e) {
            System.err.println("Error al esperar: " + e.getMessage());
        }

        // Interrumpir agentes
        agente1.interrupt();
        agente2.interrupt();
        agente3.interrupt();

        System.out.println("¡Sistema de atención finalizado!");

    }
}
