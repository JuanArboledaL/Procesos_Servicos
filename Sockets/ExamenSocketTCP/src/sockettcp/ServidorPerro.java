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

    public static void main(String[] args) throws IOException {

        String mensaje, pedir= "Dame perro";
        int posicion;
        
        SocketTCPServer servidor = new SocketTCPServer(50001);
        servidor.start();
        servidor.abrirCanalesdeTexto();
        servidor.abrirObjeto();
        
        servidor.enviarMensajedeTexto("Dame Gato");
        
        mensaje = servidor.recibirMensajedeTexto();
        System.out.println("mensaje recibido: " +  mensaje);
        
        while(!mensaje.equals(pedir)){
        
            mensaje = servidor.recibirMensajedeTexto();
            System.out.println("mensaje recibido: " +  mensaje);
        }
        
        if(mensaje.equals(pedir)){
        
            servidor.enviarNumero(listaPerros.length);
            servidor.enviarMensajedeTexto("OK. POSICION");   
        }
        
        posicion =servidor.recibirNumero();
        System.out.println("Posicion recibida: "+ posicion);
        
        if(posicion > listaPerros.length){
        
            servidor.enviarMensajedeTexto("ERROR");
            
        }else{
            
            servidor.enviarMensajedeTexto("CORRECTO");
            Perro perro = listaPerros[posicion];
            servidor.enviarObjeto(perro);
            System.out.println("Objeto enviado: " + perro);
            servidor.enviarMensajedeTexto("ENVIO PERRO");
        }
        
        servidor.cerrarCanalesdeTexto();
        servidor.cerrarObjeto();
        servidor.stop();
 
    }
}
