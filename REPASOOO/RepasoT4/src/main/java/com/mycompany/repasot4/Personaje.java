/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasot4;

/**
 *
 * @author juana
 */
public class Personaje {
    
    private int id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;

    public Personaje(int id, String name, String status, String species, String gender, String image) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }
  
    
}
