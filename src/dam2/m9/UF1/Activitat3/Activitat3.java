package activitat3;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Activitat3 {
    public static void main(String[] args) {
        
        byte[] encoded;
        encoded = passwordKeyGeneration("yangshun", 128).getEncoded();
        for (int i=0; i<encoded.length; i++) {
			System.out.println(Integer.toBinaryString(encoded[i] & 0xFF).replace(' ', '0')+ "-"+ encoded[i] );
		}
    }
    
    public static SecretKey passwordKeyGeneration(String text, int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128)||(keySize == 192)||(keySize == 256)){
            try {
                byte[] data = text.getBytes("UTF-8");
                //MessageDigest md = MessageDigest.getInstance("MD5");
                //MessageDigest md = MessageDigest.getInstance("SHA-1");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize/8);
                sKey = new SecretKeySpec(key, "AES");
            } catch (Exception ex){
                System.err.println("Error generant la clau:" + ex);
            }
        }
        return sKey;
       }
}
