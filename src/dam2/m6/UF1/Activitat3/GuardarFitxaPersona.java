package dam2.m6.UF1.Activitat3;
import java.io.*;
import java.util.Scanner;
public class GuardarFitxaPersona {

    public static void main(String[] args) throws IOException  {
       File fitxer = new File("C:\\Users\\Yang\\Desktop\\persones.txt");
       Scanner sc = new Scanner(System.in);
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		//Les dades per inserir
		String nombre[] = new String[3];
		int edad[] = new int[3];
		String nacionalidad[] = new String[3];
		String direccion[] = new String[3];
		double altura[] = new double[3];
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;
		
                
		for (int i=0; i<nombre.length; i++) {
			aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes
			//50 caràcters a 2bytes/caràcter 100 bytes
                        System.out.println("Introdueix nom "+i+":");
                        nombre[i]=sc.nextLine();
			buffer = new StringBuffer (nombre[i]);
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//1 enter ocupa 4 bytes
                        System.out.println("Introdueix edad "+i+":");
                        edad[i]=sc.nextInt();
			aleatoriFile.writeInt(edad[i]);
                        sc.nextLine();
			//25 caràcters a 2bytes/caràcter 50 bytes
                        System.out.println("Introdueix nacionalidad "+i+":");
                        nacionalidad[i]=sc.nextLine();
			buffer = new StringBuffer (nacionalidad[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
			//30 caràcters a 2bytes/caràcter 60 bytes
                        System.out.println("Introdueix direccion "+i+":");
                        direccion[i]=sc.nextLine();
			buffer = new StringBuffer (direccion[i]);
			buffer.setLength(30);
			aleatoriFile.writeChars(buffer.toString());
			//1 float ocupa 4 bytes
                        System.out.println("Introdueix altura "+i+":");
                        altura[i]=sc.nextDouble();
			aleatoriFile.writeFloat((float)altura[i]);
                        sc.nextLine();
                        
			//Total 222 bytes
		}
		aleatoriFile.close();
    }
    
}
