/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private DataOutputStream  os,is;
    
    
    public Cliente(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    
    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente) Estableciento conexión...");
        socket = new Socket(serverIP, serverPort);
        is = new DataOutputStream(socket.getOutputStream());
        System.out.println("(Cliente) Conexión establecida.");
    }
    
    
    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        System.out.println("(Cliente) Conexiones cerradas.");
    }
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente("127.0.0.1",49171);
        try {
            cliente.start();
            cliente.os.writeUTF("Hola amiguito");
            System.out.println("Mensaje del servidor: " + cliente.is.toString());
            cliente.stop();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
