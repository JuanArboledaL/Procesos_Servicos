package org.example.pizzas;

public class Clasica extends Pizza {

    private boolean bordeRelleno= false;

    public Clasica(int tiempo, double precio, boolean bordeRelleno) {
        super(tiempo, precio);
        this.bordeRelleno = bordeRelleno;
    }

    public boolean getBordeRelleno() {
        return bordeRelleno;
    }

    @Override
    public String toString() {
        return "Tipo de pizza: Clásica\n" + "Precio: " + super.getPrecio() + "\n" + "Borde relleno: " + getBordeRelleno();
    }
}
