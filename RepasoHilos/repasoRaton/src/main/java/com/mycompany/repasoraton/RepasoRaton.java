/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.repasoraton;

/**
 *
 * @author juana
 */
public class RepasoRaton implements Runnable {

    private String nombre;
    private int tiempoAlimentacion;

    public RepasoRaton(String nombre, int tiempo) {

        this.nombre = nombre;
        this.tiempoAlimentacion = tiempo;
    }

    public void comer() {

        try {

            System.out.printf("El rato %s ha comenzado a alimentarse %n", nombre);
            Thread.sleep(this.tiempoAlimentacion * 1000);
            System.out.printf("El raton %s ha terminado de comer %n", nombre);

        } catch (InterruptedException e) {

            System.err.println(e.getMessage());
        }

    }

    @Override
    public void run() {

        this.comer();
    }

    public static void main(String[] args) {

        RepasoRaton r1 = new RepasoRaton("Juan", 3);
        RepasoRaton r2 = new RepasoRaton("Carlos", 2);
        RepasoRaton r3 = new RepasoRaton("Maria", 5);
        RepasoRaton r4 = new RepasoRaton("Felipe", 1);
        RepasoRaton r5 = new RepasoRaton("Valentina", 6);

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
        new Thread(r4).start();
        new Thread(r5).start();

    }

}

