package sockettcp;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientePerro {

    public static void main(String[] artgs) {

        final int PUERTO = 50001;
        int cantPerros,posicion;
        String mensaje;
        SocketTCPClient sc = new SocketTCPClient("localHost", PUERTO);
        try {
                    
            sc.start();
            sc.abrirCanalesTexto();
            
            sc.enviarTexto("Dame Gato");
            sc.enviarTexto("Dame perro");
            
            mensaje = sc.leerTexto();
            cantPerros = sc.leerNumero();
            
            mensaje += cantPerros + sc.leerTexto();
            
            System.out.println("Mensaje servidor: " + mensaje);
           
            posicion = (int)(Math.random()*cantPerros +2);
            
            sc.enviarNumero(posicion);
            mensaje = sc.leerTexto();
            
            if("ERROR".equalsIgnoreCase(mensaje)){
            
                System.out.println("Ha indicado una posición incorrecta de la lista");
                
            }else{
            
                System.out.println("Ha recibido un perro");
                System.out.println(sc.leerTexto());
            }
            
            sc.cerrarCanalesTexto();
            sc.stop();
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
