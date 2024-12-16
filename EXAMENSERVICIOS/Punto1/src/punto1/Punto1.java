/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package punto1;

/**
 *
 * @author Juanito
 */
public class Punto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int numeroOculto = (int) ((Math.random() * 100) + 1);

        for (int i = 1; i <= 10; i++) {

            NumeroOculto hilo = new NumeroOculto(numeroOculto, i);

            new Thread(hilo).start();
        }

    }

}
