/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prouctoresconsumidores;

/**
 *
 * @author juana
 */
public class Productores implements Runnable{
    
   Array list;
   int id;

    public Productores(int id,Array list){
   
        this.id = id;
        this.list = list;
    }
    
    @Override
    public void run(){
    
        int num;
        while(list.terminado == false){
        
            num = (int)(Math.random()*10 + 1);
            list.rellenar(num);
            
            System.out.println("El hilo " + this.id + " ha producido el número" + num);
        }
        
    }
}
