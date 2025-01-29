/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.act1ftp;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author juana
 */
public class Act1FTP {

    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "12345678";

    public Act1FTP() {
        clienteFTP = new FTPClient();
    }

    private void conectar() throws SocketException, IOException {
        clienteFTP.connect(SERVIDOR, PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }

        boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);

        if (!credencialesOK) {
            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas");
        }

        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }

    private void desconectar() throws IOException {
        clienteFTP.disconnect();
    }

    private boolean descargarFichero(String nombreFichero) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(nombreFichero));
        boolean recibido = clienteFTP.retrieveFile(nombreFichero, os);
        os.close();
        return recibido;
    }

    private void descargarTodo(String ruta) throws IOException {

        FTPFile ficheros[] = clienteFTP.listFiles(ruta);

        if (ficheros.length == 0) {

            System.out.println("No hay ficheros que copiar");
        } else {

            for (FTPFile fichero : ficheros) {

                descargarFichero(fichero.getName());
                System.out.println(fichero.getName());
            }
        }

    }

    public static void main(String[] args) {

        Act1FTP gestor = new Act1FTP();

        try {

            gestor.conectar();
            System.out.println("Conectado");

            gestor.descargarTodo("/");

            gestor.desconectar();
            System.out.println("Desconectado");

        } catch (Exception e) {

            System.err.print("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
