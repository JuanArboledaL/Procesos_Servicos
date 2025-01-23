package ejercicio1;

public class JugadorNumero implements Jugador extends Thread{
    
    int saldo;
    int id;
    Casino casino;
    
    public JugadorNumero(int num, int saldo, Casino casino){
    
       this.saldo = saldo;
       this.id = num;
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
    public String toString() {

        String cadena = "Id: " + id + "\nSaldo: " + this.saldo+ "\nTipo: JugadorNumero";
        return cadena;
    }
    
    
}