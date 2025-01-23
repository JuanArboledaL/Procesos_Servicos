
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Juanito
 */
public class ServerUDP {

    public static void main(String[] args) {

        DatagramSocket socket;

        try {

            System.out.println("(Servidor) Creando socket");
            socket = new DatagramSocket(44444);

            System.out.println("(Servidor) Recibiendo datagrama...");
            byte[] bufferLectura = new byte[64];
            DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(datagramaEntrada);

            if (bufferLectura.length == 0) {

                System.out.println("(Servidor) Enviando datagrama...");
                byte[] mensajeEnviado = new String("ERROR").getBytes();
                DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
                        datagramaEntrada.getAddress(),
                        datagramaEntrada.getPort());
                socket.send(datagramaSalida);
            }
            else{
                
                System.out.println("(Servidor) Enviando datagrama...");
                byte[] mensajeEnviado = new String(bufferLectura).getBytes();
                DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
                        datagramaEntrada.getAddress(),
                        datagramaEntrada.getPort());
                socket.send(datagramaSalida);
                
            }

            System.out.println("(Servidor) Cerrado sockets...");
            socket.close();
            System.out.println("(Servidor) Socket cerrado.");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
