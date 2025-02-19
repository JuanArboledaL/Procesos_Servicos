package org.example.pizzas;

public class Pizza {


    private static int cod = 0;
    private int tiempo;
    private double precio;


    public Pizza(int tiempo, double precio) {
        cod = ++cod;
        this.tiempo = tiempo;
        this.precio = precio;
    }

    public static int getCod() {
        return cod;
    }

    public static void setCod(int cod) {
        Pizza.cod = cod;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
