package cotxes;
import java.io.*;
public class EscriureCotxes {
    public static void main(String[] args) throws IOException {
		Cotxes cotxes1;
		File fitxer = new File("C:\\Users\\Alumne\\Downloads\\cotxes.txt");
		FileOutputStream fileout = new FileOutputStream(fitxer);
		ObjectOutputStream dataOuCotxes = new ObjectOutputStream(fileout);
		String marca[]={"Ford","Renault","Lamborghini"};
                String model[]={"Focus","203","Evo"};
                int any[]={2003,2001,2020};
                String matricula[]={"SU12839A","AA1293WA","JS3782SD"};
		for (int i=0; i<marca.length; i++){//Crea la comarca
			cotxes1 = new Cotxes(marca[i], model[i],any[i],matricula[i]);
			dataOuCotxes.writeObject(cotxes1);//L'escriu al fixer
		}
		dataOuCotxes.close();
    }
}
