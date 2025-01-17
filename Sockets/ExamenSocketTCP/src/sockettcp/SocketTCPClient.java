package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketTCPClient {

    String serverIP;
    int serverPort;
    Socket socket;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    ObjectInputStream objIn;
    ObjectOutputStream objOu;
    
    public SocketTCPClient(int puerto, String ip) throws IOException {

        serverPort = puerto;
        serverIP = ip;
    }

    public void start() throws IOException {

        System.out.println("(Cliente) Esperando conexiones...");
        socket = new Socket(serverIP,serverPort);
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Cliente) Conexión establecida.");
    }

    public void stop() throws IOException {

        System.out.println("(Cliente) Cerrando conexiones....");
        is.close();
        os.close();
        System.out.println("(Cliente) Conexiones cerradas.");
    }
    
    public void enviarNumero(int num) throws IOException {

        System.out.println("(Cliente) Enviando número...");
        os.write(num);
        System.out.println("(Cliente) Número enviado.");
    }
    
    public int recibirNumero() throws IOException{
    
        System.out.println("(Cliente) Recibiendo número...");
        int numero =is.read();
        System.out.println("(Cliente) Número recibido.");
        return numero;
    }

    public void abrirCanalesdeTexto() {

        System.out.println("(Cliente) Abriendo canales de texto...");
        dos = new DataOutputStream(os);
        dis = new DataInputStream(is);
        System.out.println("(Cliente) Canalaes de textos abiertos.");
    }

    public void enviarMensajedeTexto(String mensaje) throws IOException {

        System.out.println("(Cliente) enviando mensaje de texto...");
        dos.writeUTF(mensaje);
        System.out.println("(Cliente) mensaje de texto enviado");
    }

    public String recibirMensajedeTexto() throws IOException {

        System.out.println("(Cliente) recibiendo mensaje de texto");
        String mensaje = dis.readUTF();
        System.out.println("(Cliente) mensaje de texto recibido");
        return mensaje;
    }

    public void cerrarCanalesdeTexto() throws IOException {

        System.out.println("(Cliente) Cerrando canales de texto...");
        dis.close();
        dos.close();
        System.out.println("(Cliente) canales de texto cerrados.");
    }

    public void abrirObjeto() throws IOException {

        System.out.println("(Cliente) Abriendo objeto...");
        objOu = new ObjectOutputStream(os);
        objIn = new ObjectInputStream(is);
        System.out.println("(Cliente) objeto abierto.");
    }
    
    public void enviarObjeto(Object objeto) throws IOException {

        System.out.println("(Cliente) Enviar objeto...");
        objOu.writeObject(objeto);
        System.out.println("(Cliente) Objeto enviado.");
    }
    
    public Object recibirObjeto() throws IOException {

        System.out.println("(Cliente) Recibiendo objeto...");
        Object object = objIn.read();
        System.out.println("(Cliente) Objeto recibido.");
        return object;
    }
    
    public void cerrarObjeto() throws IOException {

        System.out.println("(Cliente) Cerrando objeto...");
        objOu.close();
        objIn.close();
        System.out.println("(Cliente) Objeto cerrado.");
    }
    
//    public SocketTCPClient(String serverIP, int serverPort) {
//        this.serverIP = serverIP;
//        this.serverPort = serverPort;
//    }
//
//    public void start() throws UnknownHostException, IOException {
//        System.out.println("(Cliente) Estableciendo conexión...");
//        socket = new Socket(serverIP, serverPort);
//        is = socket.getInputStream();
//        os = socket.getOutputStream();
//        System.out.println("(Cliente) Conexión establecida.");
//    }
//
//    public void stop() throws IOException {
//        System.out.println("(Cliente) Cerrando conexiones...");
//        is.close();
//        os.close();
//        socket.close();
//        System.out.println("(Cliente) Conexiones cerradas.");
//    }
//    
//    public void texto(){
//    
//        dis = new DataInputStream(is);
//        dos = new DataOutputStream(os);
//    }

}
