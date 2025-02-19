package pizzeriaBelen;

/**
 *
 * @author alvar
 */
public class Clasica extends Pizza {

    private boolean tieneQueso = false;
    
    
    
    public Clasica(double precio, int segundosEnHorno) {
        super(precio, segundosEnHorno);
    }
    
     public Clasica(double precio, int segundosEnHorno, boolean borde) {
        super(precio, segundosEnHorno);
        this.tieneQueso = borde;
    }
    
    public boolean isTieneQueso() {
        return tieneQueso;
    }

    public void setTieneQueso(boolean tieneQueso) {
        this.tieneQueso = tieneQueso;
    }

    @Override
    public String toString() {
        String cadena = super.toString();
        if (tieneQueso) {
            cadena += " -- Tiene relleno el borde";
        } else {
            cadena += " -- No tiene relleno el borde";
        }

        return cadena;
    }

}
