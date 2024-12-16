/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adivinarnum;

/**
 *
 * @author Juanito
 */
public class AdivinarNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int num = (int)(Math.random()*100);
        NumOculto n = new NumOculto();
        
        for (int i = 0; i < 10; i++) {
            
            new Thread(n).start();
        }
    }
    
}
