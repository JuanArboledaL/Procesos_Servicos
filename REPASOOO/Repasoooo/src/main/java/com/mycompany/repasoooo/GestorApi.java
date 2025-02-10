/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasoooo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Juanito
 */
public class GestorApi {
    
    private String api="https://rickandmortyapi.com/api/character/";
    private int id;

    public GestorApi(int id) {
        this.id = id;
    }
    
    public String llamarApi() throws MalformedURLException, IOException{
    
        String url = api + id;
        URL urlApi = new URL(url);
        
        HttpURLConnection connection = (HttpURLConnection) urlApi.openConnection();
        connection.setRequestMethod("GET");
        
        if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
        
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
            
        }else{
        
            return null;
        }
    }
     
    public int obtenerId(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            Personaje p = gson.fromJson(llamarApi,Personaje.class);
            return p.getId();
        }else{
        
            return -1;
        }
    }
    
    public String obtenerName(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            Personaje p = gson.fromJson(llamarApi,Personaje.class);
            return p.getName();
        }else{
        
            return null;
        }
    }
    
    obtenerId
    mainApi
    llamarApi
    descargarImagen
    importApi
    importCorreo
    
    
}
