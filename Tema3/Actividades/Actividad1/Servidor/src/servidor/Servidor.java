/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private ServerSocket serverSocket;
    private String mensajeServidor;
    private Socket socket;
    private DataOutputStream entradaServidor, salidaCliente;

    public Servidor(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println("(Servidor) Esperando conexiones...");
        socket = serverSocket.accept();
        salidaCliente = new DataOutputStream(socket.getOutputStream());
        salidaCliente.writeUTF("holasss");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while(( mensajeServidor = entrada.readLine()) != null){
        
            System.out.println(entradaServidor);
        }
        System.out.println("(Servidor) Conexión establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando conexiones...");
        salidaCliente.close();
        entradaServidor.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor(49171);
            servidor.start();
            System.out.println("Mensaje del cliente: " + servidor.salidaCliente.toString());
            servidor.entradaServidor.write(200);
            servidor.stop();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
