package org.example;

public abstract class Personaje {
    private int vida;
    private static int id =0;

    public Personaje(int vida) {
        this.vida = vida;
        id++;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public static int getId() {
        return id;
    }

}
