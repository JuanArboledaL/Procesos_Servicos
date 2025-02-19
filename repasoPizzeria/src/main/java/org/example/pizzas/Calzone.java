package org.example.pizzas;

public class Calzone extends Pizza {

    public Calzone(int tiempo, double precio) {

        super(tiempo, precio+(precio*0.05));

    }

    @Override
    public String toString() {
        return "Tipo de pizza: Calzone\n"+"Precio: " + super.getPrecio();
    }
}
