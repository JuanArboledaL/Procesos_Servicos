package org.example.horno;

public class Cola<T> implements AccionesEstructuras<T> {

    private T[] espera;
    private int numElementos;

    public Cola(int capacidad) {
        this.espera = (T[]) new Object[capacidad];
        this.numElementos = 0;
    }

    @Override
    public boolean push(T elemento) {

        boolean posible = false;
        if(numElementos >= espera.length) {

            posible = false;

        }else{

            espera[numElementos++] = elemento;
            posible = true;
        }

        return posible;
    }

    @Override
    public T pop() {

        T objeto = espera[0];

        for(int i = 1; i < espera.length-1; i++) {

            espera[i] = espera[i+1];
        }
        this.numElementos--;

        return objeto;
    }

    @Override
    public boolean esVacia() {
        return numElementos == 0;
    }

    @Override
    public int getNumeroElementos() {

        return numElementos;
    }
}
