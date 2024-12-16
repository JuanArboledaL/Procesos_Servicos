/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2hilos;

/**
 *
 * @author juana
 */
public class AreaTriangulo extends Thread {

    int base, altura, area;

    public AreaTriangulo(int base, int altura) {

        this.altura = altura;
        this.base = base;

    }

    @Override
    public void run() {

        this.area = (base * altura) / 2;

        System.out.println("La base del triangulos es: " + this.base + " La altura del triangulo es: " + this.altura + " El area en total de este rtriangulo es de: " + this.area);

    }
}
