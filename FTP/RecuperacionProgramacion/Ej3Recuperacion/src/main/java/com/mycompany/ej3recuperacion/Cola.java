/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej3recuperacion;

/**
 *
 * @author Juanito
 */
public class Cola<T> {
    
    private int numElementos;
    private T[] cola;

    public Cola(int numElementos) {
        this.numElementos = numElementos;
    }

    public boolean encolar(T elemento) {

        if (numElementos >= cola.length) {
            return false;
        }

        cola[this.numElementos++] = elemento;
        return true;
    }

    public T desencolar() {
        T objetoDevuelto = cola[0];

        for (int i=0; i <this.numElementos - 1; i++) {
            cola[i] = cola[i+1];
        }
        this.numElementos--;

        return objetoDevuelto;
    }

    public boolean listaVacia() {

        return this.numElementos == 0;
    }

    public int numeroElemento() {

        return this.numElementos;
    }
}
