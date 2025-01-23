package ejercicio1;

public class Banca {
    
    // El saldo nunca podra ser negativo
    private int saldo;
    private String nombre;
   
    public Banca(int saldo){
    
        this.saldo = saldo;
    }
    
    // Incrementa el saldo de la banca en lo que indica el parametro incremento
    public int incrementarSaldo(int incremento) {

        this.saldo += incremento;
        
        return saldo;
    }
    
    
    // Decrementa el saldo de la banca en lo que indica el paramentro decremento.
    public int decrementarSaldo(int decremento) {

        this.saldo -= decremento;
        return saldo;
    }
    
    // Devuelve el saldo de la banca
    public int getSaldo(){
        return saldo;
    }
    
}
