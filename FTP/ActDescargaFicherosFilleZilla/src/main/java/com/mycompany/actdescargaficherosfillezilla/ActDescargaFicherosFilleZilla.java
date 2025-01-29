/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actdescargaficherosfillezilla;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Juanito
 */
public class ActDescargaFicherosFilleZilla {

    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "12345678";    

     private void conectar() throws SocketException, IOException {
        clienteFTP.connect(SERVIDOR,PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }
        
        boolean credencialesOK = clienteFTP.login(USUARIO,PASSWORD);
        
        if (!credencialesOK) {
            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas");     
        }
        
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }
    
    
    private void desconectar() throws IOException {
        clienteFTP.disconnect();
    }
   
    private boolean descargarFichero(String ficheroRemoto, String pathLocal) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(pathLocal));
        boolean recibido = clienteFTP.retrieveFile(ficheroRemoto,os);
        os.close();
        return recibido;
        
    }
    
    public void descargarTodoElContenido() throws IOException{
    
        FTPFile ficheros[] = clienteFTP.listFiles();
        
        
    }
    
    public static void main(String[] args) {
     
        ActDescargaFicherosFilleZilla gestor = new ActDescargaFicherosFilleZilla();
        
        try{
        
            gestor.conectar();
            System.out.println("Conectado");
            
            
        }catch(Exception e){
        
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
