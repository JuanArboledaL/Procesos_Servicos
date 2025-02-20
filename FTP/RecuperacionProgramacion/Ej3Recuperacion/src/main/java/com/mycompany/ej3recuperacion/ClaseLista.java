/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej3recuperacion;

/**
 *
 * @author Juanito
 */
public class ClaseLista <T>{
 
    private static Object lista[] = new Object[30];

    public ClaseLista() {

    }

    public void insertartarPosicion(T elemento, int posicion) {

        if( lista[posicion] == null) {


        }
        lista[posicion] = elemento;
    }

    public Object sacarPosicion(int posicion) {

        Object elemento;

        if(lista[posicion] == null) {

            elemento = null;
        }else{

            elemento = lista[posicion];
        }

        return elemento;
    }

    public boolean listaVacia(){

        boolean vacia;

        if(lista.length == 0){
            vacia = true;
        }else{
            vacia = false;
        }

        return vacia;
    }

    public boolean listaLlena(){

        boolean llena;

        if(lista.length == 30){
            llena = true;
        }else{
            llena = false;
        }
        return llena;
    }

    public int numeroElemento(){

        return lista.length;
    }
}
