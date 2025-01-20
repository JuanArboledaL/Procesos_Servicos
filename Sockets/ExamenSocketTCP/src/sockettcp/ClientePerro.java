package sockettcp;

import java.io.IOException;

public class ClientePerro {

    public static void main(String[] artgs) throws IOException, ClassNotFoundException {

        final int PUERTO = 50001;
        int cantPerros, posicion;
        String mensaje;

        SocketTCPClient cliente = new SocketTCPClient(PUERTO, "localHost");

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

        posicion = (int) (Math.random() * cantPerros + 2);

        cliente.enviarNumero(posicion);

        mensaje = cliente.recibirMensajedeTexto();
        System.out.println(mensaje);

        if (mensaje.equals("ERROR")) {

            System.out.println("Ha indicado una posición incorrecta de la lista");

        } else {

            Perro perro = (Perro) cliente.recibirObjeto();
            mensaje = cliente.recibirMensajedeTexto();
            System.out.println("Objeto recibido: " + perro);
            System.out.println("Mensaje recibido: " + mensaje);

        }

        cliente.cerrarObjeto();
        cliente.cerrarCanalesdeTexto();
        cliente.stop();

    }

}
