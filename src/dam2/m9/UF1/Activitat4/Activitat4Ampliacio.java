package dam2.m9.UF1.Activitat4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Yang
 */
public class Activitat4Ampliacio {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String clau;
        String arxiuRuta;
        int tamanyArxiu = 256;
        
        System.out.println("Introdueix la paraula clau: ");
        clau = sc.nextLine();
        System.out.println("Introdueix la ruta del arxiu a encriptar/desencriptar: ");
        arxiuRuta = sc.nextLine();
        
        Path path = Paths.get(arxiuRuta);
        
        SecretKey sKey = passwordKeyGeneration(clau, tamanyArxiu);
        
        byte[] data = Files.readAllBytes(path);
       byte[] encryptData = encryptData(sKey, data);
        byte[] decryptData = decryptData(sKey, encryptData);
        
        String encriptat;
        encriptat = new String(encryptData);
	//System.out.println("La paraula encriptada: " + encriptat);
        
	String desencriptat;
        desencriptat = new String(decryptData);
	//System.out.println("La paraula desencriptada: " + desencriptat);
        
        //dividim la path en abans i després del .
        String[] partesPath = arxiuRuta.split("\\.");
        String partNom = partesPath[0];
        String partTipus = partesPath[1];
        
         //Creem el arxiu encriptat
        try{
            File file = new File(partNom + "_X." + partTipus);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(encriptat);
            bw.close();
            System.out.println("La informarcio encriptada esta al arxiu " + file);
        } catch (Exception ex) {
            System.err.println("Uff algo anda mal");
        }
        
          try{
            File file1 = new File(partNom + "_Y." + partTipus);
            FileWriter fw1 = new FileWriter(file1);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(desencriptat);
            bw1.close();
            System.out.println("La informarcio desencriptada esta al" + file1);
        } catch (Exception ex) {
            System.err.println("Uff algo anda mal");
        }
    }
    
     //Generar clau
     public static SecretKey passwordKeyGeneration(String text, int keySize) {
	SecretKey sKey = null;
	if ((keySize == 128) || ( keySize == 192) || (keySize == 256)) {
            try {
                byte[] data = text.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize/8);
                sKey = new SecretKeySpec(key, "AES");
            } catch (Exception ex) {
                System.out.println("Error generant la clau: " + ex);
            }
	}
	return sKey;
    }
    //Encriptar
    public static byte[] encryptData(SecretKey sKey, byte[] data) {
	byte[] encryptedData = null;
        
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
	}catch (Exception ex) {
            System.err.println("Error xifrant les dades: " + ex);
	}
        
	return encryptedData;
    }
    //Desencriptar
    public static byte[] decryptData(SecretKey sKey, byte[] data) {
    byte[] encryptedData = null;
    try {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, sKey);
    encryptedData = cipher.doFinal(data);
    }
    catch (Exception ex) {
    System.err.println("Error dexifrant les dades: " + ex);
    }
    return encryptedData;
}
}
