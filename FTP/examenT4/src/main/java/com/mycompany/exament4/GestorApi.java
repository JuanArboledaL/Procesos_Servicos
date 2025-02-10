/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exament4;

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
    
    private String urlApi = "https://fakestoreapi.com/products/";    
    private int id;

    public GestorApi(int id) {
        this.id = id;
    }
    
    public String llamarApi() throws MalformedURLException, IOException{
    
        String url = urlApi + id;
        URL urlApi = new URL(url);
        
        HttpURLConnection connection = (HttpURLConnection) urlApi.openConnection();
        connection.setRequestMethod("GET");
        
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
            
        } else {
            
            return null;
        }
        
        
    }
    
    public int obtenerId(String llamarApi) {
        
        if (llamarApi != null) {
            
            Gson gson = new Gson();
            api a = gson.fromJson(llamarApi, api.class);
            return a.getId();
        } else {
            
            return -1;
        }
    }
    
    public String obtenerTitle(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            api a = gson.fromJson(llamarApi, api.class);
            return a.getTitle();
        
        }else{
        
            return null;
        }
        
    }
    
    public double obtenerPrice(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            api a = gson.fromJson(llamarApi, api.class);
            return a.getPrice();
            
        }else{
        
            return 0.0;
        }
    
    }
    
    public String obtenerDescription(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            api a = gson.fromJson(llamarApi, api.class);
            return a.getDescrption();
        }else{
        
            return null;
        }
    }
    
    public String obtenerCategory(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            api a = gson.fromJson(llamarApi, api.class);
            return a.getCategory();
            
        }else{
        
            return null;
        }
        
    }
    
    public String obtenerImagen(String llamarApi){
    
        if(llamarApi != null){
        
            Gson gson = new Gson();
            api a = gson.fromJson(llamarApi, api.class);
            return a.getImage();
            
        }else{
        
            return null;
        }
        
    }
    
    
 
    
}
