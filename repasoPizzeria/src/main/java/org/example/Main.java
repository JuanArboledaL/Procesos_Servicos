package org.example;

import org.example.horno.Cola;
import org.example.pizzas.Calzone;
import org.example.pizzas.Clasica;
import org.example.pizzas.Pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        menu();

    }

    public static void menu(){

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        System.out.println("--Bienvenido a nuestra pizzeria--");
        do{

            System.out.print("""
                Menú:
                1. Insertar Pizza
                2. Cantidad Porcentual de pizzas clásicas en espera
                3. Encendido del horno
                4. salir
                Ingrese una opción:
                """);
            opcion = sc.nextInt();
            acciones(opcion);

        }while(opcion != 4);

    }

    public static void acciones(int opcion){

        Cola cola = new Cola(2);

        Scanner sc = new Scanner(System.in);
        int tipo, tiempo,queso;
        double precio;
        boolean insertada;
        switch(opcion){

            case 1->{
                System.out.print("Ingresa un tiempo de cocción para tu pizza: ");
                tiempo = sc.nextInt();
                System.out.print("Ingresa el valor de tu pizza: ");
                precio = sc.nextDouble();
                System.out.print("Indica que tipo de pizza deseas:\n1) Si desea pizza clásica \n2) Si desea un Calzone");
                tipo = sc.nextInt();
                if(tipo == 1){

                    do{
                        System.out.print("¿Desea su pizza Clasica con borde relleno de queso? (1)SI o (2)No:");
                        queso = sc.nextInt();
                    }while(queso < 1 && queso > 2);
                    if(queso == 1){

                        Clasica c = new Clasica(tiempo,precio,true);
                        insertada = cola.push(c);
                    }else{
                        Clasica c = new Clasica(tiempo,precio,false);
                        insertada = cola.push(c);
                    }
                }else{

                    Calzone calzone = new Calzone(tiempo,precio);
                    insertada = cola.push(calzone);
                }

                if(insertada == true){

                    System.out.println("Se ha ingresado la pizza correctamente");
                }else{
                    System.out.println("No se ha podido ingresar la pizza");
                }

            }
            case 2->{


            }
            case 3->{

            }
            case 4->{
                System.out.println("Ha salido de nuestra pizzeria");
            }
        }
    }


}