package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient {

    String serverIP;
    int serverPort;
    Socket socket;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    
    public SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente) Estableciendo conexión...");
        socket = new Socket(serverIP, serverPort);
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Cliente) Conexión establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        System.out.println("(Cliente) Conexiones cerradas.");
    }
    
   public void abrirCanalesTexto() {
        System.out.println("(Cliente) Abriendo canales de texto...");
        dis = new DataInputStream(dis);
        dos = new DataOutputStream(dos);
        System.out.println("(Cliente) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesTexto() throws IOException {
        System.out.println("(Cliente) Cerrando canales de texto...");
        dis.close();
        dos.close();
        System.out.println("(Cliente) Canales de texto cerrados.");
    }
    
    public int leerNumero() throws IOException {
        int numero = is.read();
        return numero;
    }
    
    public String leerTexto() throws IOException {
        String mensaje = dis.readUTF();   
        return mensaje;
    }
    
    public void enviarNumero(int numero) throws IOException {
        os.write(numero);
    }
    
    public void enviarTexto(String mensaje) throws IOException {
        dos.writeUTF(mensaje);
    }

}
