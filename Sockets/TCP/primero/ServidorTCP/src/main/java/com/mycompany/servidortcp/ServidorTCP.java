/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.servidortcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juana
 */
public class ServidorTCP {

    public static void main(String[] args) {
            
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        String mensaje ;
        
        final int PUERTO = 5000;
        
        try {
            
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciando");
            
            while(true){
            
                sc = servidor.accept();
                
                System.out.println("----Cliente Conectado-----");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("¡Hola mundo desde el servidor!");
                sc.close();
                
                System.out.println("------Cliente desconectado-----");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
