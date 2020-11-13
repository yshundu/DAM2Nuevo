/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF1.Activitat5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author Yangshun Du
 */
public class Act5UF1 {

    /**
     * @param args the command line arguments
     1) Ha de demanar una frase per encriptar (una línia màxim).
     2) L’algoritme ha de generar el parell de claus (publica i privada) de longitud 512.
     3) Ha d’encriptar el missatge amb la clau pública i mostrar-ne el contingut encriptat.
     4) Ha de desencriptar el missatge amb la clau privada i mostrar-ne el contingut (que haurà de ser igual que la frase que volíeu encriptar inicialment)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paraula;
        //longitud de la clau
        int longitudClau = 512;
        System.out.println("Introdueix frase per encriptar (una línia maxima)");
        paraula = sc.nextLine();
        //generem les dos claus
        KeyPair Key = randomGenerate(longitudClau);
        //definim les claus
        byte[] bytesParaula = paraula.getBytes();
        PublicKey publicKey = Key.getPublic();
        PrivateKey privateKey = Key.getPrivate();
        //guardem el encriptat
        byte[] encriptat = encryptData(bytesParaula,publicKey);
        //Mostrem paraula encriptada
        String textEncriptat;
        textEncriptat = new String(encriptat);
	System.out.println("La paraula encriptada: " + textEncriptat);
        //guardem el desencriptat
        byte[] desencriptat = decryptData(encriptat,privateKey);
        String textDesencriptat;
        textDesencriptat = new String(desencriptat);
	System.out.println("La paraula desencriptada: " + textDesencriptat);
        
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
    //Encriptar
    public static byte[] encryptData(byte[] data, PublicKey pub) {
        byte[] encryptedData = null;
        try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
        cipher.init(Cipher.ENCRYPT_MODE, pub);
        encryptedData = cipher.doFinal(data);
        }
        catch (Exception ex) {
        System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
    //Desencriptar
     public static byte[] decryptData(byte[] encrypted, PrivateKey priv) {
        byte[] decryptData = null;
        try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
        cipher.init(Cipher.DECRYPT_MODE, priv);
        decryptData = cipher.doFinal(encrypted);
        }
        catch (Exception ex) {
        System.err.println("Error xifrant: " + ex);
        }
        return decryptData;
    }
}
