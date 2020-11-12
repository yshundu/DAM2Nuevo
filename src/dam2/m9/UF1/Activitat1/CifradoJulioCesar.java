package cifradojuliocesar;

import java.util.*;
class CifradoJulioCesar {
   
    public static StringBuffer cifrado(String texto, int cambios) {
        StringBuffer resultado= new StringBuffer(); 
        for (int i=0; i<texto.length(); i++) {
            if (Character.isWhitespace(texto.charAt(i))){
                char letra = (char)'5';
                resultado.append(letra);
            } else {
                char letra = (char)(((int)texto.charAt(i) +
                        cambios - 97) % 26 + 97);
                resultado.append(letra);
            }
        }
        return resultado; 
    }

    public static void main(String[] args) {
        String texto;
        int saltos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce texto a cifrar (En minuscula): ");
        texto=sc.nextLine();
        System.out.println("Introduce cantidad de saltos de letra: ");
        saltos=sc.nextInt();
        System.out.println("Texto  : " + texto); 
        System.out.println("Saltos : " + saltos); 
        System.out.println("Cifrado: " + cifrado(texto, saltos)); 
    }
}