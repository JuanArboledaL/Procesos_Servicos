package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SocketTCPClient {
    private String serverHost;
    private int serverPort;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    
    public SocketTCPClient(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }
    
    // Inicia el servidor
    public void start() throws IOException {
        System.out.println("(Cliente) Esperando conexión...");
        socket = new Socket(serverHost, serverPort);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
        System.out.println("(Cliente) Conexión establecida.");
    }
    
    // Detiene el servidor
    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando servidor...");
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("(Cliente) Servidor cerrado.");
    }
    
    public void abrirCanalesTexto() {
        System.out.println("(Cliente) Abriendo canales de texto...");
        dataInputStream = new DataInputStream(inputStream);
        dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("(Cliente) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesTexto() throws IOException {
        System.out.println("(Cliente) Cerrando canales de texto...");
        dataInputStream.close();
        dataOutputStream.close();
        System.out.println("(Cliente) Canales de texto cerrados.");
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
