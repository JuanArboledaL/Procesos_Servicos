/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2hilos;

/**
 *
 * @author juana
 */
public class Ejercicio2Hilos {

    public static void main(String[] args) {
        
        AreaTriangulo a1 = new AreaTriangulo(2,6);
        AreaTriangulo a2 = new AreaTriangulo(3,7);
        AreaTriangulo a3 = new AreaTriangulo(4,5);
        AreaTriangulo a4 = new AreaTriangulo(5,6);
        AreaTriangulo a5 = new AreaTriangulo(6,7);
        AreaTriangulo a6 = new AreaTriangulo(2,8);
        AreaTriangulo a7 = new AreaTriangulo(4,6);
        AreaTriangulo a8 = new AreaTriangulo(9,6);
        AreaTriangulo a9 = new AreaTriangulo(7,2);
        AreaTriangulo a10 = new AreaTriangulo(6,6);
        
       a1.start();
       a2.start();
       a3.start();
       a4.start();
       a5.start();
       a6.start();
       a7.start();
       a8.start();
       a9.start();
       a10.start();
    }
}
