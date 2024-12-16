/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.econcurrencia_1;

/**
 *
 * @author juana
 */
public class NewClass implements Runnable {

    static int cont=0;
 
    @Override
    public void run() {
        
        ejecutar();
    }
    
    public synchronized void ejecutar(){
    
        for (int i = 0; i < 5000; i++) {
            cont++;
        }
        System.out.println(cont);
    }
}
