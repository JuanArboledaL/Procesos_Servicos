package ejercicio1;

public class Casino {
    
    private static final int NUM_HILOS = 6; // 3 hilos por cada estrategia
    
    private static final int SALDO_INICIAL_JUGADOR = 1000;
    private static final int SALDO_INICIAL_BANCA = 5000;
    public static final int APUESTA = 10;
    
    private String nombre;
    private Banca banca;
    
    public Casino (String nombre) {
        this.nombre = nombre;
        banca = new Banca(SALDO_INICIAL_BANCA);
    }

    public Banca getBanca() {
        return this.banca;
    }
    

    public static void main(String[] args) {
        
        Casino casino = new Casino("Casino Belen");

        for (int i = 1; i <= NUM_HILOS; i++) {
            
            if (i % 2 == 0) {
                new JugadorNumero(i,SALDO_INICIAL_JUGADOR,casino).start();
            } else {
                new JugadorParImpar(i,SALDO_INICIAL_JUGADOR,casino).start();
            }

        }
        

    }
}

