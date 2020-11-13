package dam2.m9.UF1.Activitat4;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/*
Fet per Yangshun Du
Activitat 4 UF1 M9
En l’activitat anterior ja heu vist com generar una clau a partir d’una contrasenya,
i l’algoritme d’encriptació AES ens permet encriptar un missatge a partir d’una clau
i amb aquesta mateixa clau, podem desencriptar el missatge.

En aquesta activitat heu de realitzar un programa que rebrà dos paràmetres (2 paraules):
Contrasenya a partir de la qual creareu la clau per encriptar/desencriptar missatges
Paraula que volen encriptar

El programa ha de crear la clau a partir de la contrasenya, encriptar el segon paràmetre,
mostrar-lo per pantalla tal i com heu fet en les activitats anteriors, i finalment desencriptar
el missatge (i també mostrar-ho per pantalla).

Podeu escollir el mode CBC o ECB.

*/
public class Activitat4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String clau;
        String paraulaClau;
        int tamanyArxiu = 256;
        
        System.out.println("Introdueix la paraula clau: ");
        clau = sc.nextLine();
        System.out.println("Introdueix la paraula a encriptar: ");
        paraulaClau = sc.nextLine();
        
        SecretKey sKey = passwordKeyGeneration(clau, tamanyArxiu);
        
        byte[] paraulesClaus = paraulaClau.getBytes();
        byte[] encryptData = encryptData(sKey, paraulesClaus);
        byte[] decryptData = decryptData(sKey, encryptData);
        
        String encriptat;
        encriptat = new String(encryptData);
	System.out.println("La paraula encriptada: " + encriptat);
        
	String desencriptat;
        desencriptat = new String(decryptData);
	System.out.println("La paraula desencriptada: " + desencriptat);
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