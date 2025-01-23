package ejercicio1;

public class JugadorParImpar implements Jugador extends Thread{

    int saldo;
    int id;
    Casino casino;
    
    Ruleta rul;
    public JugadorParImpar(int num, int saldo, Casino casino){
    
        this.id = num;
        this.saldo = saldo;
        this.casino = casino;
    }

    
    public int ganar(int ganancias){
    
        this.saldo += ganancias;
        return saldo;
    }
    
    public int apostar(int apuesta){
    
       this.saldo-= apuesta;
       return saldo;
    }
    
    public boolean puedeSeguir(){
    
        boolean seguir = false;
        if(saldo > 0){
        
            seguir = true;
        }
        
        return seguir;
    }

    @Override
    public void run(){
    
        
    }
    
    @Override
    public String toString() {

        String cadena = "Id: " + id + "\nSaldo: " + this.saldo+ "\nTipo: JugadorNumero";
        return cadena;
    }

}