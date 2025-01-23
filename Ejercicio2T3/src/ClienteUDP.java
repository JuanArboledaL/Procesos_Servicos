
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juanito
 */
public class ClienteUDP {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del fichero: ");
        String strMensaje = sc.nextLine() +".txt";
        DatagramSocket socketUDP;
        
        try {
            System.out.println("(Cliente): Estableciendo parametros de conexion...");
            InetAddress hostServidor = InetAddress.getByName("localhost");
            int puertoServidor = 44444;
            
            System.out.println("(Cliente): Creando socket...");
            socketUDP = new DatagramSocket();
            
            System.out.println("(Cliente) Enviando datagrama....");
            byte[] mensaje = strMensaje.getBytes();
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length,
                                                         hostServidor, puertoServidor);
            socketUDP.send(peticion);
           
            System.out.println("(Cliente) Recibiendo datagrama....");
            byte[] buffer = new byte[64];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length,
                                                         hostServidor, puertoServidor);
            socketUDP.receive(respuesta);
            System.out.println("(Cliente): Mensaje recibido: " + new String(buffer));
            
            System.out.println("(Cliente): Cerrando socket...");
            socketUDP.close();
            System.out.println("(Cliente) Socket cerrado.");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
