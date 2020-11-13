package dam2.m9.UF1.Activitat6;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Yang
 */
public class Desencriptacio {
    private static SecretKeySpec secretKey;
    public static void main(String[] args) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchPaddingException {
        // Llegim la clau privada
        byte[] keyBytes = Files.readAllBytes(Paths.get("D:\\DAM2\\M9\\Act6\\M9Act6\\clauPrivada"));
        //Creem les claus
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey clauPrivada = keyFactory.generatePrivate(spec);

        //Guardem la clau encriptada en bytes
        byte[] clauEncriptada = Files.readAllBytes(Paths.get("D:\\DAM2\\M9\\Act6\\M9Act6\\ZZZ_clau_encriptada.txt"));
        String clauDesencriptada = new String(decryptKey(clauEncriptada, clauPrivada));

        // Guardem el missatgeEncriptat en bytes
        byte[] missatgeEncriptat = Files.readAllBytes(Paths.get("D:\\DAM2\\M9\\Act6\\M9Act6\\ZZZ_missatge_encriptat.txt"));
        
        // Desencriptem el missatge
        String missatge = new String(decrypt(missatgeEncriptat, clauDesencriptada));
        System.out.println(missatge);

    }


    public static String decrypt(byte[] text, String contrasenya) {
        try {
                    MessageDigest sha = null;
            try {
                byte[] key = contrasenya.getBytes("UTF-8");
                sha = MessageDigest.getInstance("SHA-1");
                key = sha.digest(key);
                key = Arrays.copyOf(key, 16);
                secretKey = new SecretKeySpec(key, "AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(text)));
        } catch (Exception e) {
            System.out.println("Error descifrant: " + e.toString());
        }
        return null;
    }

    public static String decryptKey(byte[] clauEncriptada, PrivateKey clauPrivada) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, clauPrivada, cipher.getParameters());
        byte[] plainBytesDecrypted = cipher.doFinal(clauEncriptada);
        return new String(plainBytesDecrypted, "UTF8");
    }

}