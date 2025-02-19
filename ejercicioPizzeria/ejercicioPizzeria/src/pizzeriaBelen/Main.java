package pizzeriaBelen;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvaroVillalon
 */
public class Main {
    
    private static Scanner teclado = new Scanner(System.in);
    
    private static Pizza elegirPizza() {
        double precio;
        int segundosHorno, tipoPizza;
        char lecturaBorde;
        boolean borde;
        Pizza pizza;
        
        System.out.print("Indique precio de la pizza:");
        precio = teclado.nextDouble();
        System.out.print("Indique los segundos que tiene que estar en el horno: ");
        segundosHorno = teclado.nextInt();
        do {
            System.out.print("Indique si es Clasica [1] o Calzone [2]: ");
            tipoPizza = teclado.nextInt();
        } while ((tipoPizza < 1) || (tipoPizza > 2));
        if (tipoPizza == 1) {
            do {
                System.out.print("Indique si quiere el borde relleno con queso [S/N]: ");
                lecturaBorde = teclado.next().toUpperCase().charAt(0);
            } while ((lecturaBorde != 'S')&&(lecturaBorde != 'N'));
            borde = (lecturaBorde == 'S');
            pizza = new Clasica(precio,segundosHorno,borde);
        } else {
            pizza = new Calzone(precio,segundosHorno);
        }
        
        return pizza;
    }
    
    private static void hornear(Pizza pizza) {
        
        try {
            Thread.sleep(pizza.getSegundosEnHorno()*1000);
        } catch (InterruptedException ex) {
            
        }
    }

    public static int menu() {
        int opcion = 0;
        
        do {
            System.out.println("\n\n -- Bienvenido a nuestra Pizzeria -- ");
            System.out.println("1. ¿Que pizza pide?");
            System.out.println("2. Porcentaje de pizzas clasicas con bordes rellenos de queso");
            System.out.println("3. Encendemos el horno");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
        } while ((opcion < 0) || (opcion > 3));
        return opcion;
    }
    
    
    public static void main(String[] args){
        
        int opcion, numeroPizzas, numPizzasClasicasConBorde = 0;
        Cola<Pizza> pizzeria = new Cola<>(3);
        Pizza pizza;
        
        do {
            opcion = menu();
            
            switch (opcion) {
                case 1 -> {
                    pizza = elegirPizza();
                    System.out.println(pizzeria.push(pizza)
                            ? "Se ha añadido su pizza en el horno"
                            : "El horno esta lleno. Espere, por favor");
                }
                case 2 -> {
                    numPizzasClasicasConBorde = 0;
                    numeroPizzas = pizzeria.getNumElementos();
                    for (int contador = 1; contador <= numeroPizzas; contador++) {
                        pizza = pizzeria.pop();
                        if (pizza instanceof Clasica clasica) {
                            if (clasica.isTieneQueso())
                                numPizzasClasicasConBorde++;
                        }
                        pizzeria.push(pizza);
                    }
                    if (numeroPizzas > 0)
                        System.out.printf("El porcentaje es: %.2f", (numPizzasClasicasConBorde*100.0/numeroPizzas));
                    else
                        System.out.println("No hay ninguna pizza");
                }
                case 3 -> {
                    
                    // Damos prioridad a las calzones
                    numeroPizzas = pizzeria.getNumElementos();
                    for (int contador = 1; contador <= numeroPizzas; contador++) {
                        pizza = pizzeria.pop();
                        if (pizza instanceof Calzone) {
                            System.out.println(pizza.toString());
                            hornear(pizza);
                        } else {
                           pizzeria.push(pizza);
                        }
                    }
                    
                    // Horneamos el resto
                    numeroPizzas = pizzeria.getNumElementos();
                    for (int contador = 1; contador <= numeroPizzas; contador++) {
                        pizza = pizzeria.pop();
                        System.out.println(pizza.toString());
                        hornear(pizza);
                    }        
                }  
            }
        } while (opcion != 0);
    }

    
}