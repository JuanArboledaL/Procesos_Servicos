package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    
    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }
    
    // Inicia el servidor
    public void start() throws IOException {
        System.out.println("(Servidor) Esperando conexiones...");
        
        socket = serverSocket.accept();
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }
    
    // Detiene el servidor
    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando servidor...");
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Servidor cerrado.");
    }
    
    public void abrirCanalesTexto() {
        System.out.println("(Servidor) Abriendo canales de texto...");
        dataInputStream = new DataInputStream(inputStream);
        dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("(Servidor) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesTexto() throws IOException {
        System.out.println("(Servidor) Cerrando canales de texto...");
        dataInputStream.close();
        dataOutputStream.close();
        System.out.println("(Servidor) Canales de texto cerrados.");
    }
    
    public int leerNumero() throws IOException {
        int numero = inputStream.read();
        
        return numero;
    }
    
    public String leerTexto() throws IOException {
        String mensaje = dataInputStream.readUTF();
        
        return mensaje;
    }
    
    public void enviarNumero(int numero) throws IOException {
        outputStream.write(numero);
    }
    
    public void enviarTexto(String mensaje) throws IOException {
        dataOutputStream.writeUTF(mensaje);
    }
}