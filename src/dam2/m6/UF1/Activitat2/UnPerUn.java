package cotxes;
import java.io.*;
import java.util.Scanner;
public class UnPerUn {
    public static void main(String[] args) throws IOException {
		Cotxes cotxes1;
                Scanner sc = new Scanner(System.in);
                int acabado=0;
                int opcion;
                int contador=0;
                String scmarcas;
                String scmodel;
                int scany;
                String scmatricula;
		File fitxer = new File("C:\\Users\\Alumne\\Downloads\\cotxes.txt");
		FileOutputStream fileout = new FileOutputStream(fitxer);
		ObjectOutputStream dataOuCotxes = new ObjectOutputStream(fileout);
		String marca[]= new String[10];
                String model[]=new String[10];
                int any[]=new int[10];
                String matricula[]=new String[10];
                while((acabado!=1)||(contador==10)){
                System.out.println("Elije la opción: ");
                System.out.println("1. Añadir coche. (Hasta un maximo de 10 coches) ");
                System.out.println("2. Mostrar coches. ");
                System.out.println("3.Salir");
                opcion=sc.nextInt();
                if (opcion==1){
                        System.out.println("Introdueix marca: ");
                        scmarcas=sc.next();
                        marca[contador]=scmarcas;
                        System.out.println("Introdueix model: ");
                        scmodel=sc.next();
                        model[contador]=scmodel;
                        System.out.println("Introdueix any: ");
                        scany=sc.nextInt();
                        any[contador]=scany;
                        System.out.println("Introdueix matricula: ");
                        scmatricula=sc.next();
                        matricula[contador]=scmatricula;
			cotxes1 = new Cotxes(marca[contador], model[contador],any[contador],matricula[contador]);
                        contador++;
			dataOuCotxes.writeObject(cotxes1);//L'escriu al fixer
                }else if (opcion==2){
                    for(int y=0;y<contador;y++){
                        System.out.print("\n");
                        System.out.println(marca[y]);
                        System.out.println(model[y]);
                        System.out.println(any[y]);
                        System.out.println(matricula[y]);
                        System.out.print("\n");
                    }
                }else if (opcion==3){
                    acabado=1;
                }else{
                    System.out.println("Caracter no reconocido");
                }
                }
                System.out.println("Programa terminado");
		dataOuCotxes.close();
    }
}
