package examenobjeto;

import java.io.IOException;

public class ClientePerro {

    public static void main(String[] artgs) throws IOException {

        final int PUERTO = 50001;
        int cantPerros, posicion;
        String mensaje;
        
        SocketTCPClient cliente = new SocketTCPClient(PUERTO,"localHost");
        
        cliente.start();
        cliente.abrirCanalesdeTexto();
        cliente.abrirObjeto();
        
        mensaje = cliente.recibirMensajedeTexto();
        System.out.println("Mensaje de texto recibido: " + mensaje);
        cliente.enviarMensajedeTexto("Dame perro");
        
        cantPerros = cliente.recibirNumero();
        System.out.println("Número recibido: " + cantPerros);
        mensaje = cliente.recibirMensajedeTexto();
        System.out.println("Mensaje recibido: " + mensaje);
        
        posicion = (int)(Math.random()*cantPerros +2);
        
        cliente.enviarNumero(posicion);
        
        mensaje = cliente.recibirMensajedeTexto();
        System.out.println(mensaje);
        
        if(mensaje.equals("ERROR")){
        
            System.out.println("Ha indicado una posición incorrecta de la lista");
        }else{
            
            Perro perro = (Perro) cliente.recibirObjeto();
            mensaje = cliente.recibirMensajedeTexto();
            System.out.println("Mensaje recibido: " + mensaje);
            System.out.println("Objeto recibido: "+perro);
        }
        
        cliente.cerrarObjeto();
        cliente.cerrarCanalesdeTexto();
        cliente.stop();
        
        
        
//        final int PUERTO = 50001;
//        int cantPerros,posicion;
//        String mensaje;
//        SocketTCPClient sc = new SocketTCPClient("localHost", PUERTO);
//        try {
//           
//            //Recibe el mensaje Dame Gato
//            sc.start();
//            //System.out.println(sc.dis.readUTF());
//            sc.dos.writeUTF("Dame perro");
//            
//            //recibe el tamaño del array de perros
//            cantPerros = sc.is.read();
//            sc.dis.readUTF();
//            
//            posicion = (int)(Math.random()*cantPerros +2);
//            
//            sc.os.write(posicion);
//            mensaje = sc.dis.readUTF();
//            
//            if(mensaje.equals("ERROR")){
//            
//                System.out.println("Ha indicado una posición incorrecta de la lista");
//                
//            }else{
//            
//                
//                System.out.println("Ha recibido un perro");
//            }
//            
//            sc.stop();
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
