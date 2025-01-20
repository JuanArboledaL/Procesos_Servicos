package examenobjeto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    ObjectInputStream objIn;
    ObjectOutputStream objOu;

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

    public void enviarNumero(int num) throws IOException {

        System.out.println("(Server) Enviando número...");
        os.write(num);
        System.out.println("(Server) Número enviado.");
    }
    
    public int recibirNumero() throws IOException{
    
        int numero =is.read();
        return numero;
    }

    public void stop() throws IOException {

        System.out.println("(Servidor) Cerrando conexiones....");
        is.close();
        os.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    }

    public void abrirCanalesdeTexto() {

        System.out.println("(Server) Abriendo canales de texto...");
        dos = new DataOutputStream(os);
        dis = new DataInputStream(is);
        System.out.println("(Server) Canalaes de textos abiertos.");
    }

    public void enviarMensajedeTexto(String mensaje) throws IOException {

        System.out.println("(Server) enviando mensaje de texto...");
        objOu.writeUTF(mensaje);
        System.out.println("(Server) mensaje de texto enviado");
    }

    public String recibirMensajedeTexto() throws IOException {

        System.out.println("(Server) recibiendo mensaje de texto");
        String mensaje = (String)objIn.readUTF();
        System.out.println("(Server) mensaje de texto recibido");
        return mensaje;
    }

    public void cerrarCanalesdeTexto() throws IOException {

        System.out.println("(Server) Cerrando canales de texto...");
        dis.close();
        dos.close();
        System.out.println("(Server) canales de texto cerrados.");
    }

    public void abrirObjeto() throws IOException {

        System.out.println("(Server) Abriendo objeto...");
        objIn = new ObjectInputStream(is);
        objOu = new ObjectOutputStream(os);
        System.out.println("(Server) objeto abierto.");
    }

    public void enviarObjeto(Object objeto) throws IOException {

        System.out.println("(Server) Enviar objeto...");
        objOu.writeObject(objeto);
        System.out.println("(Server) Objeto enviado.");
    }

    public void recibirObjeto() throws IOException {

        System.out.println("(Server) Recibiendo objeto...");
        objIn.read();
        System.out.println("(Server) Objeto recibido.");
    }

    public void cerrarObjeto() throws IOException {

        System.out.println("(Server) Cerrando objeto...");
        objOu.close();
        objIn.close();
        System.out.println("(Server) Objeto cerrado.");
    }
//    public SocketTCPServer(int puerto) throws IOException {
//        serverSocket = new ServerSocket(puerto);
//    }
//
//    public void start() throws IOException {
//        System.out.println("(Servidor) Esperando conexiones...");
//        socket = serverSocket.accept();
//        is = socket.getInputStream();
//        os = socket.getOutputStream();
//        System.out.println("(Servidor) Conexión establecida.");
//    }
//
//    public void stop() throws IOException {
//        System.out.println("(Servidor) Cerrando conexiones...");
//        is.close();
//        os.close();
//        socket.close();
//        serverSocket.close();
//        System.out.println("(Servidor) Conexiones cerradas.");
//    }
//    
//    public void texto(){
//    
//        dis = new DataInputStream(is);
//        dos = new DataOutputStream(os);
//    }

}
