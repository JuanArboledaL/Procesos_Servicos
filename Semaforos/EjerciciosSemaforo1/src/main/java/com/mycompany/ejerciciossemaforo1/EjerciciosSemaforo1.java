/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciossemaforo1;

/**
 *
 * @author juana
 */
public class EjerciciosSemaforo1 {

    public static void main(String[] args) {
        
        Codigo c = new Codigo();
        
        for (int i = 0; i < 4; i++) {
            
            new Thread(c).start();
        }
    }
}
