/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberia;

/**
 *
 * @author Juanito
 */
public class Cliente implements Runnable{
    
    private GestorSillas gestorSillas;

    public Cliente(GestorSillas gestorSillas) {
        this.gestorSillas = gestorSillas;
    }

    @Override
    public void run() {
        // Los clientes no esperan que haya sillas libres, no hay bucle infinito.
        // Si no hay sillas libres se van...
        entrarEnBarberia();
    }
    
    public void entrarEnBarberia() {
        int posSillaLibre = gestorSillas.getPosSillaLibre();
        if (posSillaLibre == -1) {
            System.out.println("Nuevo cliente - No habia sillas libres, me marcho");
            return;
        }
        System.out.println("Nuevo cliente se sienta en la silla: " + posSillaLibre);
    }
}
