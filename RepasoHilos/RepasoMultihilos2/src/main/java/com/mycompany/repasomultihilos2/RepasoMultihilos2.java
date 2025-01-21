/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.repasomultihilos2;

/**
 *
 * @author juana
 */
public class RepasoMultihilos2 {

    public static void main(String[] args) {
        
        Corredores c1 = new Corredores("juan");
        Corredores c2 = new Corredores("Alberto");
        Corredores c3 = new Corredores("Fernando");
        
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        
        
    }
}
