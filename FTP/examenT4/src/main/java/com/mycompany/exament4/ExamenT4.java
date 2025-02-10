/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.exament4;

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
public class ExamenT4 {

    public static void DescargarImagen(String urlImagen) throws FileNotFoundException, IOException{
    
        URL url = new URL(urlImagen);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        
        InputStream inputStream = new BufferedInputStream(conexion.getInputStream()); 
        FileOutputStream outputStream = new FileOutputStream("api.jpg");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
        }
    }
    
    public static void main(String[] args) throws IOException {

        GestorApi gestor = new GestorApi(2);
        String llamadaApi = gestor.llamarApi();

        String cadenaApi = "";

        cadenaApi+= "id: " + gestor.obtenerId(llamadaApi)+ "\n";
        cadenaApi+= "id: " + gestor.obtenerTitle(llamadaApi)+ "\n";
        cadenaApi+= "id: " + gestor.obtenerPrice(llamadaApi)+ "\n";
        cadenaApi+= "id: " + gestor.obtenerDescription(llamadaApi)+ "\n";
        cadenaApi+= "id: " + gestor.obtenerCategory(llamadaApi)+ "\n";
        cadenaApi+= "id: " + gestor.obtenerId(llamadaApi)+ "\n";
        DescargarImagen(gestor.obtenerImage(llamadaApi));
        
        
        System.out.println("Informacion de la Api: \n" + cadenaApi);

        
    }
    
    

}
