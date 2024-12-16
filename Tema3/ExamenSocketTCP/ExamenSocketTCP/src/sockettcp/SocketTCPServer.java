package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    InputStream is;
    OutputStream os;

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println("(Servidor) Esperando conexiones...");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) Conexión establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    }
    
    public void abrirCanalesTexto() {
        System.out.println("(Servidor) Abriendo canales de texto...");
        dis = new DataInputStream(is);
        dos = new DataOutputStream(os);
        System.out.println("(Servidor) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesTexto() throws IOException {
        System.out.println("(Servidor) Cerrando canales de texto...");
        dis.close();
        dos.close();
        System.out.println("(Servidor) Canales de texto cerrados.");
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
