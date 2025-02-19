package pizzeriaBelen;

/**
 *
 * @author alvar
 */
//Podria usar T como generico
public class Cola<T> implements AccionesEstructuras<T> {

    private int numElementos;
    private T[] cola;

    public Cola(int capacidad) {
        cola = (T[])new Object[capacidad];
        numElementos = 0;
    }

    @Override
    public boolean push(T elemento) {
        
        //Porque el array quedaría un numero por debajo al empezar en 0
        if (numElementos >= cola.length) {
            return false;
        } 
        
        cola[this.numElementos++] = elemento;
        return true;      
    }

    @Override
    public T pop() {
        T objetoDevuelto = cola[0];
        
        for (int i=0; i <this.numElementos - 1; i++) {
            cola[i] = cola[i+1];
        }
        this.numElementos--;
        
        return objetoDevuelto; 
    }

    @Override
    public boolean esVacia() {
       
        return this.numElementos == 0;
    }

    @Override
    //GetnumElementos y getPizzasEnHorno hacen la misma funcion y como lo hemos hecho con un contador devolvemos pizzasEnHorno y listo
    public int getNumElementos() {
        
        return this.numElementos;
    }
}
