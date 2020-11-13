package dam2.m9.UF1.Activitat6;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Yang
 */
public class Generacio {
     public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //longitud de la clau
        int longitudClau = 512;
        PrivateKey clauPrivada;
        PublicKey clauPublica;
        //generem les dos claus
        KeyPair Key = randomGenerate(longitudClau);
        clauPrivada = Key.getPrivate();
        clauPublica = Key.getPublic();
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Key.getPublic().getEncoded());
            FileOutputStream fos = new FileOutputStream("clauPublica");
            fos.write(x509EncodedKeySpec.getEncoded());
            fos.close();
            }
        catch (Exception e) { System.out.println("ERROR guardant clau publica");
        }
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Key.getPrivate().getEncoded());
            FileOutputStream fos = new FileOutputStream("clauPrivada");
            fos.write(pkcs8EncodedKeySpec.getEncoded());
            fos.close();
            }
        catch (Exception e) { System.out.println("ERROR guardant clau privada"); }
        
    }
    //Generar clau
    public static KeyPair randomGenerate(int longuitudClau) {
        KeyPair keys = null;
        try {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(longuitudClau);
        keys = keyGen.genKeyPair();
        }
        catch (Exception ex) {
        System.err.println("Generador no disponible.");
        }
        return keys;
    }
}