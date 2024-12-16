/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prouctoresconsumidores;

/**
 *
 * @author juana
 */
public class ProuctoresConsumidores {

    public static void main(String[] args) {

        Array list = new Array();
        Productores p = new Productores(1,list);
        Productores p2 = new Productores(2,list);
        Consumidor c = new Consumidor(list);
        
        new Thread(p).start();
        new Thread(p2).start();
        new Thread(c).start();
        
    }
}
