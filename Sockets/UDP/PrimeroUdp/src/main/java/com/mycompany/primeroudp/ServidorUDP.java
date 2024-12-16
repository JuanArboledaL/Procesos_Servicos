/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primeroudp;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juana
 */
public class ServidorUDP {
    
    public static void main(String[] args) {

        final int PUERTO = 5000;
        
        try {
            DatagramSocket socketUDP =new DatagramSocket(PUERTO);
            
            
        } catch (SocketException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
