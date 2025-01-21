/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasomultihilos;

/**
 *
 * @author juana
 */
public class Operaciones implements Runnable{

    int num1, num2;
    String op;
    
    public Operaciones(int num1, int num2, String op){
    
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }
    
    @Override
    public void run() {
        
        double resultado;
        
        try{
        
            switch(op){
            
                case "Suma"->{
                
                    resultado = num1 + num2;
                    System.out.println("El resultado de " + num1 + op + num2 + " es: " + resultado);
                }
                case "Resta"->{
                
                    resultado = num1 - num2;
                    System.out.println("El resultado de " + num1 + op + num2 + " es: " + resultado);
                }
                case "Division" ->{
                
                    resultado = num1 / num2;
                    System.out.println("El resultado de " + num1 + op + num2 + " es: " + resultado);
                }
                case "Multiplicacion"->{
                
                    resultado = num1 * num2;
                    System.out.println("El resultado de " + num1 + op + num2 + " es: " + resultado);
                }
            }
            
        }catch(Exception e){
        
            System.err.println("Ha ocurrido un error" + e.getMessage());
        }
        
    }

    
    
}
