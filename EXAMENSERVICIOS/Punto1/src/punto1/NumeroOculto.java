/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanito
 */
public class NumeroOculto implements Runnable {

    private static boolean numeroDescubierto = false;
    private static int numeroOculto;
    private final int id;
    private int numAleatorio;
    private static final Semaphore semaforo = new Semaphore(10);

    public NumeroOculto(int numeroOculto, int id) {
        this.numeroOculto = numeroOculto;
        this.id = id;
    }

    @Override
    public void run() {

        while (numeroDescubierto != true) {

            try {
                semaforo.acquire();
                int resultado = adivinarNumero();
                if (resultado == -1) {
                    System.out.println("YA SE HA ENCONTRADO EL NÚMERO");
                }else{
                
                    System.out.println("Hilo " + id + " con el número " + numAleatorio + " no es correcto");
                }
                semaforo.release();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public synchronized int adivinarNumero() {

        int solucion = 0;

         this.numAleatorio= (int) (Math.random() * 100) + 1;

        if (numAleatorio != numeroOculto) {
            
        } else {
            System.out.println("El hilo " + id + " ha encontrado el número oculto, es: " + numeroOculto);
            this.numeroDescubierto = true;
            solucion = -1;

        }

        return solucion;
    }

}
