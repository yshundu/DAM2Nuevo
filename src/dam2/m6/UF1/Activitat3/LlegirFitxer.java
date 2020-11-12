package ex3noaval;
import java.io.*;
public class LlegirFitxer {
    public static void main(String[] args) throws IOException {
      File fitxer = new File("C:\\Users\\Yang\\Desktop\\persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		//Apuntador s'inicialitza apuntant a l'inici del fitxer
		int apuntador = 0, edad, id;
		float altura;
		char nombre[] = new char[50], nacionalidad[] = new char[25], direccion[] = new char[30], aux;
		
		//Recorrer el fitxer llibres
		for (;;) {
			aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
			//Llegeix ID
			id = aleatoriFile.readInt();
			//Llegeix Títol
			for(int i = 0; i<nombre.length; i++) {
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
			System.out.println("ID: "+id+"\nNombre: "+nombres+"\nEdad: "+edad+"\nNaciolidad: "+nacionalidads+"\nDireccion: "+direccions+"\nAltura: "+altura+"cm\n\n");
			//S'ha de posicionar l'apuntador al següent llibre
			apuntador += 222;
			//Si coincideix on s'està apuntat amb el final del fitxer, sortim
			if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
		}
		aleatoriFile.close();//Tancar el fitxer
  
    }
}
