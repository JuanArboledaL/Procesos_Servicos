/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1hilos;

/**
 *
 * @author juana
 */
public class Ejercicio1Hilos {

    public static void main(String[] args) {
        
        Hilos h1 = new Hilos("carlos");
        Hilos h2 = new Hilos("Juan");
        Hilos h3 = new Hilos("Juliana");
        Hilos h4 = new Hilos("Cramen");
        Hilos h5 = new Hilos("Rosa");
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        
    }
}
