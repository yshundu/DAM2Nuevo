package dam2.m9.UF1.Activitat1;
import java.util.Scanner;

public class forcaBrutaJulioCesar {
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
       public static void main(String[] args) {
        String texto;
        int saltos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce texto cifrado (En minuscula): ");
        texto=sc.nextLine();
        System.out.println("Texto  cifrado    : " + texto); 
        for(int i=1;i<28;i++){
        System.out.println("Descifrado "+i+": " + descifrado(texto, i));
        }
       }
}
