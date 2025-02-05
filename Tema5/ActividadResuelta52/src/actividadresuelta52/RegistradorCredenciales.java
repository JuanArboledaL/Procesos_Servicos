package actividadresuelta52;
import java.math.BigInteger;


public class RegistradorCredenciales {
    
    public static String mostrarResumenHexadecimal(byte[] resumen) {
        String resumenHexadecimal = String.format("%064x",new BigInteger(1,resumen));
        return resumenHexadecimal;
    }
    
}
