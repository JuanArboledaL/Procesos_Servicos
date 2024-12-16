/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.econcurrencia_1;

/**
 *
 * @author juana
 */
public class EConcurrencia_1 {

    public static void main(String[] args) {
        
        NewClass n = new NewClass();
        
        for (int i = 0; i < 4; i++) {
            
            new Thread (n).start();
        }
    }
}
