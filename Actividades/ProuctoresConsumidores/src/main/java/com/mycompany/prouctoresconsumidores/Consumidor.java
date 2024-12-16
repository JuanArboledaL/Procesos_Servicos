/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prouctoresconsumidores;

/**
 *
 * @author juana
 */
public class Consumidor implements Runnable {

    Array list;
    int sum = 0;

    public Consumidor(Array list) {

        this.list = list;
    }

    @Override
    public void run() {

        while (list.terminado == false) {

            sum += list.consumir();
            System.out.println("Suma consumidor: " + sum);

            if (sum >= 50) {

                list.setTerminado(true);
            }
        }
    }

}
