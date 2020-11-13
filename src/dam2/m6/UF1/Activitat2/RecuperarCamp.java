package dam2.m6.UF1.Activitat2;

import java.io.*;
import java.util.Scanner;

public class RecuperarCamp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    Cotxes cotxes1;
    Scanner sc = new Scanner(System.in);
    int acabado=0;
    int opcion;
    String seleccion;
    int ano;
    File fitxer = new File("C:\\Users\\Alumne\\Downloads\\cotxes.txt");
    FileInputStream filein = new FileInputStream(fitxer);
    ObjectInputStream dataInCotxes = new ObjectInputStream(filein);
    

        System.out.println("Introduce el campo del coche a buscar:");
        System.out.println("1. Marca");
        System.out.println("2. Modelo");
        System.out.println("3. Año");
        System.out.println("4 .Matricula");
        opcion=sc.nextInt();
        if (opcion==1){
            System.out.println("Introduce marca a buscar: ");
            seleccion=sc.next();
            try{
            cotxes1 = (Cotxes) dataInCotxes.readObject();
            while(true){
                if(cotxes1.getMarca().equalsIgnoreCase(seleccion)){
                System.out.println("Marca: " +cotxes1.getMarca()+ "   Model: "+ cotxes1.getModel()+ "  Any: "+ cotxes1.getAny()+ "  Matricula: "+cotxes1.getMatricula());
                }
             cotxes1 = (Cotxes) dataInCotxes.readObject();
            }
            }
            catch(Exception e){}
        }else if(opcion==2){
            System.out.println("Introduce modelo a buscar: ");
            seleccion=sc.next();
            try{
            cotxes1 = (Cotxes) dataInCotxes.readObject();
            while(true){
                if(cotxes1.getModel().equalsIgnoreCase(seleccion)){
                System.out.println("Marca: " +cotxes1.getMarca()+ "   Model: "+ cotxes1.getModel()+ "  Any: "+ cotxes1.getAny()+ "  Matricula: "+cotxes1.getMatricula());
                }
             cotxes1 = (Cotxes) dataInCotxes.readObject();
            }
            }
            catch(Exception e){}
        }else if(opcion==3){
            System.out.println("Introduce año a buscar: ");
            ano=sc.nextInt();
            try{
            cotxes1 = (Cotxes) dataInCotxes.readObject();
            while(true){
                if(cotxes1.getAny()==ano){
                System.out.println("Marca: " +cotxes1.getMarca()+ "   Model: "+ cotxes1.getModel()+ "  Any: "+ cotxes1.getAny()+ "  Matricula: "+cotxes1.getMatricula());
                }
             cotxes1 = (Cotxes) dataInCotxes.readObject();
            }
            }
            catch(Exception e){}
        }else if(opcion==4){
            System.out.println("Introduce matricula a buscar: ");
            seleccion=sc.next();
            try{
            cotxes1 = (Cotxes) dataInCotxes.readObject();
            while(true){
                if(cotxes1.getMatricula().equalsIgnoreCase(seleccion)){
                System.out.println("Marca: " +cotxes1.getMarca()+ "   Model: "+ cotxes1.getModel()+ "  Any: "+ cotxes1.getAny()+ "  Matricula: "+cotxes1.getMatricula());
                }
             cotxes1 = (Cotxes) dataInCotxes.readObject();
            }
            }
            catch(Exception e){}
        }else{
         System.out.println("Caracter no valido");
        }
    dataInCotxes.close();
    }
}
