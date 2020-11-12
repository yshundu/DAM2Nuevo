
package cifradojuliocesar;

import java.util.*;

public class DescifradoJulioCesar {
    public static void main(String[] args) {
        String texto;
        int saltos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce texto cifrado (En minuscula): ");
        texto=sc.nextLine();
        System.out.println("Introduce cantidad de saltos a revertir: ");
        saltos=sc.nextInt();
        System.out.println("Texto  cifrado    : " + texto); 
        System.out.println("Saltos a revertir : " + saltos); 
        System.out.println("Descifrado: " + descifrado(texto, saltos));
    }
    
    public static StringBuffer descifrado(String texto, int cambios) { 
        StringBuffer resultado= new StringBuffer(); 
        for (int i=0; i<texto.length(); i++) {
            if (Character.isWhitespace(texto.charAt(i))){
                char letra = (char)' ';
                resultado.append(letra);
            } else {
                char letra = (char)(((int)texto.charAt(i) -
                        cambios - 97) % 26 + 97);
                resultado.append(letra);
            }
        }
        return resultado; 
    }
        
 }
