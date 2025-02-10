/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exament4;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

/**
 *
 * @author Juanito
 */
public class GestorCorreo {
    
    private Properties propiedades;
    private Session sesion;
    
    public void setPropiedadesServidorSMTP() {
        
        propiedades = System.getProperties();
        propiedades.put("mail.smtp.auth", true);
        propiedades.put("mail.smtp.host", "mail.gmx.es");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.starttls.enable", true);
        sesion = Session.getInstance(propiedades, null);
        
    }
    
    public Transport conectarServidorSMTP(String direccionEmail, String password) throws NoSuchProviderException, MessagingException {
        
        Transport t = (Transport) sesion.getTransport("smtp");
        t.connect(propiedades.getProperty("mail.smtp.host"), direccionEmail, password);
        return t;
    }
     public Message crearNucleoMensaje(String emisor, String destinatario, String asunto) throws AddressException, MessagingException {
        
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        return mensaje;
    }
     
    
}
