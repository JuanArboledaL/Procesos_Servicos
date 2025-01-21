/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.repasomultihilos;

/**
 *
 * @author juana
 */
public class RepasoMultihilos{
    
    public static void main(String[] args) {

        
        Operaciones op1 = new Operaciones(1,2,"Suma");
        Operaciones op2 = new Operaciones(5,7,"Resta");
        Operaciones op3 = new Operaciones(6,4,"Multiplicacion");
        Operaciones op4 = new Operaciones(9,1,"Division");
        
        new Thread(op1).start();
        new Thread(op2).start();
        new Thread(op3).start();
        new Thread(op4).start();
        
        
    }

    
}
