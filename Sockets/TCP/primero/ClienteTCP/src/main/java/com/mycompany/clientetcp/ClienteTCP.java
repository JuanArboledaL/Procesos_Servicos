/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clientetcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juana
 */
public class ClienteTCP {

    public static void main(String[] args) {
        
        final String HOST="127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        String mensaje;
        
        try {
            Socket sc = new Socket(HOST,PUERTO);
            
            in  = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("¡Hola mundo desde el cliente!");
            
            mensaje = in.readUTF();
            
            System.out.println(mensaje);
            
            sc.close();
        
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
