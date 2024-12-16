/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.act1hilos;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juana
 */
public class hilos extends Thread {

    String name;

    public hilos(String name) {

        this.name = name;

    }

    @Override
    public void run() {

        int random = ThreadLocalRandom.current().nextInt(1000,10000 + 1);
        
        while (true) {

            try {
                
                System.out.println("Hola soy el bucle" +  this.name + " y estoy trabajando");
                Thread.sleep(random);
                
            } catch (InterruptedException ex) {
                  ex.printStackTrace();
            }

        }
    }
}
