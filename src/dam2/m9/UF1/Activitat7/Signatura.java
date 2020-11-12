
package activititat7m9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yang
 */
public class Signatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        int longitudClau = 512;
        PrivateKey clauPrivada;
        PublicKey clauPublica;
        //generem les dos claus
        KeyPair Key = randomGenerate(longitudClau);
        clauPrivada = Key.getPrivate();
        clauPublica = Key.getPublic();
        
        //creem els arxius
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Key.getPublic().getEncoded());
            FileOutputStream fos = new FileOutputStream("clauPublica");
            fos.write(x509EncodedKeySpec.getEncoded());
            fos.close();
            System.out.println("Generant clau publica...OK");
            }
        catch (Exception e) { System.out.println("ERROR guardant clau publica");
        }
        
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Key.getPrivate().getEncoded());
            FileOutputStream fos = new FileOutputStream("clauPrivada");
            fos.write(pkcs8EncodedKeySpec.getEncoded());
            fos.close();
                    System.out.println("Generant clau privada...OK");
            }
        catch (Exception e) { System.out.println("ERROR guardant clau privada"); 
        }
        //creem els arxius firma i missatge
        System.out.println("Introdueix el missatge a signar: ");
        frase = sc.next();
        byte[] frases = frase.getBytes();
        byte[] firma = signData(frases, clauPrivada);
        
        try {
            FileOutputStream fos = new FileOutputStream("firma");
            fos.write(firma);
            fos.close();
            System.out.println("Generant arxiu firma_missatge...OK");
        } catch (Exception e) { System.out.println("ERROR guardant la firma"); 
        }
        
        try {
            FileOutputStream fos = new FileOutputStream("missatge");
            fos.write(frases);
            fos.close();
            System.out.println("Generant arxiu missatge...OK");
        } catch (Exception e) { System.out.println("ERROR guardant la firma"); 
        }
        
    }
    //metode de crear claus
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
     //metode per firmar
     public static byte[] signData(byte[] data, PrivateKey priv) {
        byte[] signature = null;
        try {
        Signature signer = Signature.getInstance("SHA1withRSA");
        signer.initSign(priv);
        signer.update(data);
        signature = signer.sign();
        }
        catch (Exception ex) {
        System.err.println("Error signant les dades: " + ex);
        }
        return signature;
    }
}
