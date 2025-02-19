package pizzeriaBelen;

/**
 *
 * @author alvar
 */
public abstract class Pizza {
    private static int id = 0;
    private int idGuardado = 0;
    private double precio;
    private int segundosEnHorno;

    public Pizza(double precio, int segundosEnHorno) {
        idGuardado = id++;
        this.precio = precio;
        this.segundosEnHorno = segundosEnHorno;
    }
    public int getId() {
        return idGuardado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSegundosEnHorno() {
        return segundosEnHorno;
    }

    public void setSegundosEnHorno(int segundosEnHorno) {
        this.segundosEnHorno = segundosEnHorno;
    }
    
    @Override
    public String toString() {
        String cadena = "\nLa pizza " + this.getClass().getSimpleName();
        cadena += " tiene el código: " + this.idGuardado + " -- El precio es de " + this.getPrecio() + " -- El tiempo de cocción es de: " + this.getSegundosEnHorno();
        return cadena;
    }
}
