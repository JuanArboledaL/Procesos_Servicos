package org.example;

import static java.lang.Integer.parseInt;

public class Jefe extends Personaje {

    private String id ="1";
    private int vidaExtra;

    public Jefe() {
        super(20);
        this.id += super.getId();
    }

    public int getVidaExtra() {
        return vidaExtra;
    }

    public void setVidaExtra() {
        int vida = parseInt(this.id);
        this.vidaExtra = vida/2;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "id='" + id + '\'' +
                ", vidaExtra=" + vidaExtra +
                '}';
    }
}
