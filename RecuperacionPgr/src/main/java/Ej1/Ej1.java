package Ej1;


public class Ej1 {
    public static void main(String[] args) {

        int num, cont, cantidades[];
        int cant = (int) (Math.random() *11 + 10);
        int[] numeros = new int [cant];
        cantidades= new int [cant];
        System.out.println(cant);
        for (int i = 0; i < cant; i++) {

            num = (int) (Math.random() * 25 + 1);
            numeros[i] = num;
            cont = contador(numeros,num);
            cantidades[i]= cont;

        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]+" ");
        }
        System.out.println();

        for (int i = 0; i < cantidades.length; i++) {
            if(cantidades[i] % 2 != 0){
                System.out.print(numeros[i]+" ");
            }
        }

    }

    public static int contador(int[] numeros,int num){

        int cont =0;
        for (int i = 0; i < numeros.length; i++) {

            if(numeros[i] == num){
                cont++;
            }
        }

        return cont;
    }

}