package sockettcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientePerro {

    public static void main(String[] artgs) {
        
        try {
            SocketTCPClient cliente = new SocketTCPClient("localhost", 50001);
            cliente.start();
            cliente.abrirCanalesTexto();
            
            cliente.enviarTexto("Dame Gato");
            cliente.enviarTexto("Dame Perro");
            
            String mensaje = cliente.leerTexto();
            
            int listaPerro = cliente.leerNumero();
            mensaje += listaPerro + "\n" + cliente.leerTexto();
            
            System.out.println("Mensaje del servidor: " + mensaje);
            
            int numAleatorio = (int) (Math.random() * listaPerro + 2);
            cliente.enviarNumero(numAleatorio);
            
            mensaje = cliente.leerTexto();
            
            if("ERROR".equalsIgnoreCase(mensaje)) {
                System.out.println("Ha solicitado una posición incorrecta.");
            } else {
                System.out.println("Va a recibir un perro.");
                System.out.println(cliente.leerTexto());
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientePerro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
        
    }
                      
}