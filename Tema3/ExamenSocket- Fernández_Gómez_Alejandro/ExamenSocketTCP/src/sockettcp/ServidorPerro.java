package sockettcp;

import java.io.IOException;

public class ServidorPerro {
    
    private static Perro[] listaPerros = {
                            new Perro("Balto",98),
                            new Perro("Chonino",40),
                            new Perro("Laika",66),
                            new Perro("Stubby",50),
                            new Perro("Smoky",51),
                            new Perro("Barry",223),
                            new Perro("Old Drum",154)
                        };
    
    
    public static void main(String[] args) {
        
        try {
            // Inicio del servidor
            SocketTCPServer servidor = new SocketTCPServer(50001);
            servidor.start();
            servidor.abrirCanalesTexto();
            
            String mensaje = servidor.leerTexto();
            
            while(!"dame perro".equalsIgnoreCase(mensaje)) {
                mensaje = servidor.leerTexto();
            }
            
            System.out.println(mensaje);
            
            servidor.enviarTexto("Tamaño de la lista de perros: ");
            servidor.enviarNumero(listaPerros.length);
            servidor.enviarTexto("OK. POSICIÓN");
            
            int numero = servidor.leerNumero();
            
            while(numero < 0 || numero > listaPerros.length) {
                servidor.enviarTexto("ERROR");
            }
            
            System.out.println("Posición leida: " + numero);
            servidor.enviarTexto("ENVIO PERRO");
            servidor.enviarTexto(listaPerros[numero].toString());
            
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
