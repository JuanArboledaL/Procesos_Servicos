package confidencialidad_identidad;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ClavesManager {
    
    public static KeyPair generarClaves() throws NoSuchAlgorithmException {
        
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(2048);
        KeyPair claves = generador.generateKeyPair();
        
        return claves;
    }
    
    public static void guardarClaves(KeyPair claves, String publica, String privada) throws Exception {
        
        FileOutputStream fos = new FileOutputStream(publica);
        fos.write(claves.getPublic().getEncoded());
        fos.close();
        fos = new FileOutputStream(privada);
        fos.write(claves.getPrivate().getEncoded());
        fos.close();
    }
    
    public static PublicKey getClavePublica(String g) throws Exception {
        
        File ficheroClavePublica = new File(g);
        byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);   
        PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);
        
        return clavePublica;
    }
    
    public static PrivateKey getClavePrivada(String  privada) throws Exception {
        
        File ficheroClavePrivada = new File(privada);
        byte[] bytesClavePrivada= Files.readAllBytes(ficheroClavePrivada.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        PrivateKey clavePrivada = keyFactory.generatePrivate(privateKeySpec);
        
        return clavePrivada;
    }
    
   
}
