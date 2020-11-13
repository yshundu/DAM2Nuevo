package dam2.m9.UF1.Activitat7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Yang
 */
public class Notaria {
    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException { 
        String sFirma = ("C:\\Users\\Yang\\Documents\\NetBeansProjects\\Activititat7M9\\firma");
        String sMissatge = ("C:\\Users\\Yang\\Documents\\NetBeansProjects\\Activititat7M9\\missatge");
        String sPubKey = ("C:\\Users\\Yang\\Documents\\NetBeansProjects\\Activititat7M9\\clauPublica");
        Path pFirma = Paths.get(sFirma);
        Path pMissatge = Paths.get(sMissatge);
        Path pPubKey = Paths.get(sPubKey);
        
        byte[] bytesPublicKey = Files.readAllBytes(pPubKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(bytesPublicKey));
        byte[] bytesFirma = Files.readAllBytes(pFirma);
        byte[] bytesMissatge = Files.readAllBytes(pMissatge);
        
        validateSignature(bytesMissatge, bytesFirma, publicKey);
        
    }
    public static boolean validateSignature(byte[] data, byte[] signature, PublicKey pub) {
    boolean isValid = false;
    try {
    Signature signer = Signature.getInstance("SHA1withRSA");
    signer.initVerify(pub);
    signer.update(data);
    isValid = signer.verify(signature);
    if(isValid == true){
    System.out.println("Comprovant signatura de l’arxiu missatge...OK");
    }else{
        System.out.println("ERROR");
    }
    }
    catch (Exception ex) {
    System.err.println("Error validant les dades: " + ex);
    }
    return isValid;
    }
    }
