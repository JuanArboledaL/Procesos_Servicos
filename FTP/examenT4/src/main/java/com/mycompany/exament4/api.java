/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exament4;

/**
 *
 * @author Juanito
 */
public class api {
    
    private int id;
    private String title;
    private double price;
    private String descrption;
    private String category;
    private String image;

    public api(int id, String title, double price, String descrption, String category, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.descrption = descrption;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescrption() {
        return descrption;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
    
    
    
}
