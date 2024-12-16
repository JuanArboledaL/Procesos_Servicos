package sockettcp;

import java.io.IOException;

public class ServidorPerro {

    private static Perro[] listaPerros = {
        new Perro("Balto", 98),
        new Perro("Chonino", 40),
        new Perro("Laika", 66),
        new Perro("Stubby", 50),
        new Perro("Smoky", 51),
        new Perro("Barry", 223),
        new Perro("Old Drum", 154)
    };

    public static void main(String[] args) {

        int posicion;

        try {
            SocketTCPServer servidor = new SocketTCPServer(50001);
            servidor.start();
            servidor.abrirCanalesTexto();
            
            String mensaje = servidor.leerTexto();
            

            while (!"Dame perro".equalsIgnoreCase(mensaje)) {
                mensaje = servidor.leerTexto();
            }

            System.out.println(mensaje);
            
            servidor.enviarTexto("Tamaño de la lista de perros: ");
            servidor.enviarNumero(listaPerros.length);
            servidor.enviarTexto("OK. Posicion");
            
            posicion = servidor.leerNumero();
            
            if(posicion > listaPerros.length || posicion < 0){
            
                servidor.enviarTexto("ERROR");
            }else{
            
                System.out.println(" posicion leida: " + posicion);
                servidor.enviarTexto("ENVIO PERRO");
                servidor.enviarTexto(listaPerros[posicion].toString());
            }
            
            servidor.cerrarCanalesTexto();
            servidor.stop();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
