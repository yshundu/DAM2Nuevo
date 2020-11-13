/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF1.Activitat6;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Yang
 */
public class Encriptacio {
     private static SecretKeySpec secretKey;
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
        Scanner sc = new Scanner(System.in);
        String rutaArxiu;
        System.out.println("Introdueix el nom del arxiu clau publica: ");
        rutaArxiu = "D:\\DAM2\\M9\\Act6\\M9Act6\\" + sc.nextLine();
        File clauPublicaFitxer = new File(rutaArxiu);
        
        if (clauPublicaFitxer.exists()){
        //Llegir clau publica
            byte[] keyBytes = Files.readAllBytes(Paths.get(rutaArxiu));

            //Guardem la clau
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey clauPublica = keyFactory.generatePublic(spec);

            // Encriptar el text a partir de una contraseña
            final String secretPassword = "lapaellaestabien";
            byte[] clauEncriptada = encryptPublic(clauPublica, secretPassword);

            // Fem la funcio de guardar arxius
            guardarArxius("ZZZ_clau_encriptada.txt", clauEncriptada);

            // Frase a encriptar
            System.out.println("Introdueix la frase a encriptar: ");
            String texteAEncriptar = sc.nextLine();

            byte[] texteEncriptat = encrypt(texteAEncriptar, secretPassword);
            guardarArxius("ZZZ_missatge_encriptat.txt", texteEncriptat);

        }
    }

    public static byte[] encrypt(String text, String contrasenya) {
        try {
            MessageDigest sha = null;
            try {
                byte[] key;
                key = contrasenya.getBytes("UTF-8");
                sha = MessageDigest.getInstance("SHA-1");
                key = sha.digest(key);
                key = Arrays.copyOf(key, 16);
                secretKey = new SecretKeySpec(key, "AES");

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encode(cipher.doFinal(text.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error descencriptant: " + e.toString());
        }
        return null;
    }

    public static byte[] encryptPublic(PublicKey clauPublica, String contrasenya) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, clauPublica);
        //guardem la contraseña en bytes
        byte[] input = contrasenya.getBytes();
        cipher.update(input);

        // Encriptem y ho retorna
        byte[] cipherText = cipher.doFinal();
        return cipherText;
    }

    public static void guardarArxius(String nomFitxer, byte[] clauEncrypt) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("D:\\DAM2\\M9\\Act6\\M9Act6\\" + nomFitxer));
            dos.write(clauEncrypt);
            dos.flush();
            dos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}