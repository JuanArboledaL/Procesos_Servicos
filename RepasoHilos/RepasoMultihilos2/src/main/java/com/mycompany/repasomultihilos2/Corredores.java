/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasomultihilos2;

/**
 *
 * @author juana
 */
public class Corredores implements Runnable{

    String nombre;
    static int puesto = 0;
    static boolean hayGanador = false;
    
    public Corredores(String nombre){
    
        this.nombre = nombre;
    }
    
    public void carrera(){
    
        int distancia = 0, aleatorio;
        
        try{
        
            while(distancia < 11){
            
                System.out.println("El corredor " + nombre + " ha avanzado: " + distancia +"m");
                distancia += 2;
                aleatorio = (int) (Math.random()* 3);
                Thread.sleep(1000 * aleatorio);
            }
            
            puesto++;
            System.out.println("El jugador " + nombre + " ha terminado la carrera");
            
            anunciarGanador(nombre);
            
        }catch(InterruptedException e){
        
            System.err.println(e.getMessage());
        }
    }
    
    private static synchronized boolean anunciarGanador(String nombre){
    
        if(!hayGanador){
        
            hayGanador = true;
            System.out.println("El corredor " +  nombre +  "ha ganado la carrera");
        }
        
        return false;
    }
    
    @Override
    public void run() {
        carrera();
    }
    
}
