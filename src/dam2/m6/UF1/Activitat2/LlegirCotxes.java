
package dam2.m6.UF1.Activitat2;
import java.io.*;
public class LlegirCotxes {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
		Cotxes cotxes1;
		File fitxer = new File("C:\\Users\\Alumne\\Downloads\\cotxes.txt");
		FileInputStream filein = new FileInputStream(fitxer);
		ObjectInputStream dataInCotxes = new ObjectInputStream(filein);
		
		try {
			while (true){
				cotxes1 = (Cotxes) dataInCotxes.readObject();
				System.out.println("Marca: " +cotxes1.getMarca()+ "   Model: "+ cotxes1.getModel()+ "  Any: "+ cotxes1.getAny()+ "  Matricula: "+cotxes1.getMatricula());
			}
		} catch (EOFException eo) {}
		dataInCotxes.close();
    }
}