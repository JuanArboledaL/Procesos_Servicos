/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciossemaforo1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juana
 */
public class Codigo implements Runnable {

    private static final Semaphore semaforo = new Semaphore(2);
    private static final Semaphore semaforo2 = new Semaphore(2);

    @Override
    public void run() {

        ejecutar1();
        ejecutar2();

    }

    public void ejecutar1() {

        try {
            semaforo.acquire();
            System.out.println("ejecutando");
            Thread.sleep(1000);
            System.out.println("finalizando");
            Thread.sleep(1000);
            semaforo.release();
        } catch (InterruptedException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void ejecutar2() {

        try {
            semaforo2.acquire();
            System.out.println("ejecutar2 ini");
            Thread.sleep(1000);
            System.out.println("ejecutar2 fin");
            Thread.sleep(1000);
            semaforo2.release();
        } catch (InterruptedException ex) {

            System.out.println(ex.getMessage());
        }
    }

    //sincronizar
    //random
    //semaforo
    //new Thread(c).start();
    //wait
    //notifyAll
}
