package ejercicio1; 



// Clase que simula la ruleta
public class Ruleta {
    
    
    // Devuelve un numero entre 0 y 36
    public static synchronized int girar() {
        
        int num = (int) (Math.random()* 35);
        return num;
    }
}
