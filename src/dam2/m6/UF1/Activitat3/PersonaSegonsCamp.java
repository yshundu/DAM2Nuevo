
package ex3noaval;
import java.io.*;
import java.util.Scanner;
public class PersonaSegonsCamp {
    public static void main(String[] args) throws IOException {
        
        File fitxer = new File("C:\\Users\\Yang\\Desktop\\persones.txt");
	RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
        Scanner sc = new Scanner(System.in);
        
        int apuntador=0, edad, id, seleccio;
        char nombre[] = new char[50], nacionalidad[] = new char[25], direccion[] = new char[30], aux;
        String MenuString = "";
        float altura;
        int menuNum = 0;
        float menuFloat=0;
        
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por nacionalidad");
        System.out.println("3. Buscar por direccion");
        System.out.println("4. Buscar por altura");
        System.out.println("5. Buscar por edad");
        
        seleccio = sc.nextInt();
        sc.nextLine();
        
        if(seleccio == 1){
            MenuString = sc.nextLine();
        } else if(seleccio == 2){
            MenuString = sc.next();
        } else if(seleccio == 3){
            MenuString = sc.next();
        } else if(seleccio == 4){
            menuFloat = sc.nextFloat();
        } else if(seleccio == 5){
            menuNum = sc.nextInt();
        }
        
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

		for(int i = 0; i<nacionalidad.length; i++) {
                    aux = aleatoriFile.readChar();
                    nacionalidad[i] = aux;
		}
		String nacionalidades = new String(nacionalidad);
                
                edad = aleatoriFile.readInt();

		for(int i = 0; i<direccion.length; i++) {
			aux = aleatoriFile.readChar();
                        direccion[i] = aux;
		}
		String direcciones = new String(direccion);
                       
                altura = aleatoriFile.readFloat();
                
		//Sortida de les dades de cada llibre
                if((nombres.trim().toLowerCase().equals(MenuString.trim().toLowerCase())) || (nacionalidades.trim().toLowerCase().equals(MenuString.trim().toLowerCase())) || (direcciones.trim().toLowerCase().equals(MenuString.trim().toLowerCase())) || (altura == menuFloat) || (edad == menuNum)){
                    System.out.println("ID: "+id+"\nNombre: "+nombres+"\nNacionalidad: "+nacionalidades+"\nDirecciones: "+direcciones+"\nAltura: "+altura+"\nEdad: "+edad+"\n\n");
                }
		
                //S'ha de posicionar l'apuntador al següent llibre
		apuntador += 222;
                
		if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
	}
        aleatoriFile.close();
 
    }
}
