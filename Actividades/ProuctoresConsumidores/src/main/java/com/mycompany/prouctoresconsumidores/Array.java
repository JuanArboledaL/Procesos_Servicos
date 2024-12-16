/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prouctoresconsumidores;


/**
 *
 * @author juana
 */
public class Array {
    
    static int numeros[];
    int cantidad = 0;
    boolean terminado = false;
    
    public Array(){
    
       numeros = new int[10];
        
    }
    
    public boolean terminado(){
    
        return terminado;
    }
    
    public void setTerminado(boolean terminado){
    
        this.terminado = terminado;
    }
    
    public synchronized boolean rellenar(int num){
    
        boolean insertado;
        
        if(cantidad < 10){
        
            numeros[cantidad]=num;
            cantidad++;
            insertado = true;
            notifyAll();
            
        }else{
        
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error " + ex.getMessage());
            }
            
            insertado = false;
        }
        
        
        return insertado;
    }
    
    public synchronized int consumir(){
    
        int numero=0;
        
        if(cantidad > 0){
        
            numero = numeros[cantidad -1];
            numeros[cantidad -1] = 0;
            cantidad--;
            notifyAll();
        }else{
        
            try {
                wait();
            } catch (InterruptedException ex) {

                System.out.println("Error " + ex.getMessage());
            }
        }
        
        return numero;
    }
}
