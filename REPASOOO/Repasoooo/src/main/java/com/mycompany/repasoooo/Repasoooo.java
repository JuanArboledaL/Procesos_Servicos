/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.repasoooo;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Juanito
 */
public class Repasoooo {

    public static void DescargarImagen(String urlImagen) throws FileNotFoundException, IOException {
        
        URL url = new URL(urlImagen);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        
        InputStream inputStream = new BufferedInputStream(conexion.getInputStream());        
        FileOutputStream outputStream = new FileOutputStream("Personaje.jpg");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }
    
    public static void main(String[] args) throws IOException {
        GestorApi gestor = new GestorApi(1);
        String llamadaApi = gestor.llamarApi();
        
        String cadenaApi = "";
        
        cadenaApi += "id: " + gestor.obtenerId(llamadaApi) + "\n";
        cadenaApi += "name: " + gestor.obtenerName(llamadaApi) + "\n";
        cadenaApi += "status: " + gestor.obtenerStatus(llamadaApi) + "\n";
        cadenaApi += "species: " + gestor.obtenerSpecies(llamadaApi) + "\n";
        cadenaApi += "species: " + gestor.obtenerGender(llamadaApi) + "\n";
        cadenaApi += "image: " + gestor.obtenerImage(llamadaApi) + "\n";
        
        System.out.print("Info cadena: \n" + cadenaApi);
        
        DescargarImagen(gestor.obtenerImagen(llamadaApi));
        
        GestorCorreo gestorCorreo = new GestorCorreo();
        
        gestorCorreo.EnviarMensajeConAdjunto("juan.arboleda@gmx.es", "PSPIESBelen", "juanArboledalopez@gmail.com", "repasoExamen", cadenaApi, "personaje.jpg");
    }
}
