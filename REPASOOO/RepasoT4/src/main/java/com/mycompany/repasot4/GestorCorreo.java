/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasot4;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author juana
 */
public class GestorCorreo {
    
    private Properties propiedades;
    private Session sesion;
    
    public void setPropiedadesServidorSMTP(){
    
        propiedades = System.getProperties();
        propiedades.put("mail.smtp.auth", true);
        propiedades.put("mail.smtp.host", "mail.gmx.es");
        propiedades.put("mail.smtp.port","587");
        propiedades.put("mail.smtp.starttls.enable", true);
        sesion = Session.getInstance(propiedades, null);
            
    }
    
    public Transport conectarServidorSMTP(String direccionEmail, String password) throws NoSuchProviderException, MessagingException{
    
        Transport t = (Transport) sesion.getTransport("smtp");
        t.connect(propiedades.getProperty("mail.smtp.host"),direccionEmail,password);
        return t;
    }
    
    public Message crearNucleoMensaje(String emisor, String destinatario, String asunto) throws AddressException, MessagingException{
    
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        return mensaje;
    }
    public Message crearMensajeConAdjunto(String emisor, String destinatario, String asunto, String texto, String nombreFichero) throws AddressException, MessagingException, IOException{
    
        Message mensaje = crearNucleoMensaje(emisor,destinatario,asunto);
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(texto);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(new File(nombreFichero));
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        multipart.addBodyPart(mimeBodyPart);
        mensaje.setContent(multipart);
        return mensaje;
    }
    
    public void EnviarMensajeConAdjunto(String emisor, String password, String destinatario, String asunto, String texto, String nombreFichero) throws AddressException, MessagingException, IOException{
        setPropiedadesServidorSMTP();
        Message mensaje = crearMensajeConAdjunto(emisor, destinatario, asunto, texto, nombreFichero);
        Transport t = conectarServidorSMTP(emisor, password);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
        
    }
    
    
}
