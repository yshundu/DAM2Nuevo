package ex3noaval;
import java.io.*;
import java.util.*;
public class ConsultarPersona {
    public static void main(String[] args) throws IOException {
		File fitxer = new File("C:\\Users\\Yang\\Desktop\\persones.txt");
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		int apuntador, edad, id, seleccio;
		float altura;
		char nombre[] = new char[50], nacionalidad[] = new char[25], direccion[] = new char[30], aux;
		//Demana a l'usuari que seleccioni el llibre pel seu identificador
		System.out.print("Introdueixi el ID de la persona a consultar: ");
		Scanner stdin = new Scanner (System.in);
				
		seleccio = stdin.nextInt();
		apuntador = (seleccio-1)*222;
		
		if (apuntador >= aleatoriFile.length()) {
			System.out.println("ERROR: ID incorrecte, no existeix aquesta persona");
		} else {//Apuntar a l'inici del llibre seleccionat al fitxer
			aleatoriFile.seek(apuntador);
			id = aleatoriFile.readInt();//Llegeix ID
			for(int i = 0; i<nombre.length; i++) {//Llegeix Títol
				aux = aleatoriFile.readChar();
				nombre[i] = aux;
			}
			String nombres = new String(nombre);
			//Llegeix ISBN
			edad = aleatoriFile.readInt();
			//Llegeix Autor
			for(int i = 0; i<nacionalidad.length; i++) {
				aux = aleatoriFile.readChar();
				nacionalidad[i] = aux;
			}
			String nacionalidads = new String(nacionalidad);
			//Llegeix Editorial
			for(int i = 0; i<direccion.length; i++) {
				aux = aleatoriFile.readChar();
				direccion[i] = aux;
			}
			String direccions = new String(direccion);
			//Llegeix Preu
			altura = aleatoriFile.readFloat();
			//Sortida de les dades de cada llibre
			System.out.println("ID: "+id+"\nNombre: "+nombres+"\nEdad: "+edad+"\nNacionalidad: "+nacionalidads+"\nDireccion: "+direccions+"\nAltura: "+altura+"cm\n\n");
		}
		aleatoriFile.close();//Tancar el fitxer

}
}