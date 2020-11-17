
package dam2.m6.UF1.ExamenUF1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Yangshun
 */
public class A_YangshunZhanDu {
        public static void main(String[] args) throws FileNotFoundException, IOException {
           Scanner sc = new Scanner(System.in);
           //Guardem el directori i fitxer
           System.out.println("Introdueix nom directori: ");
           String nomDirectori = sc.nextLine();
           System.out.println("Introdueix nom del fitxer (XML) per guardar la informacio: ");
           String nomFitxer = sc.nextLine();
           String localitzacio = ("C:\\"+nomDirectori);
           //truquem a la funcio
           funcio1(localitzacio, nomFitxer);

    }
        
        public static void funcio1 (String nomDirectori, String nomArxiu) throws FileNotFoundException, IOException{
         //Asignem la ruta del arxiu a la funcio
         File f = new File(nomDirectori);
         //Creem una file temporal
         File f2;
         String[] arxius = f.list();
         //si el directori existeix...
         if(f.exists()){
            for (int i = 0; i<arxius.length; i++){
                String temporal = (nomDirectori+"\\"+arxius[i]);
                f2 = new File(temporal);
                System.out.println("File nom: "+arxius[i]);
                //Utilitzem la fila temporal
                System.out.println("Ultima modificio: "+ f2.lastModified());
                if(f2.isDirectory() == true){
                    System.out.println("isDirectori=si");
                }else{
                    System.out.println("isDirectori=no");
                    System.out.println("Tamany: "+ f2.length());
                }
                System.out.println("\n");
                
            }
        }else{
             System.out.println("No existeix directori, programa acabat.");
         }
        }
}
