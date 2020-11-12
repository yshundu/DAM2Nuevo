/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act6m6;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import jdk.internal.org.xml.sax.SAXException;

public class JAXBSerializationExample2 {
	
	private static final String PANTALONES_XML_FILE = "pantalonesDual.xml";
 
	public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException, SAXException, org.xml.sax.SAXException {
		
		JAXBContext context = JAXBContext.newInstance(Pantalones.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Pantalones pantalones = omplePantalones();
		
		//Mostrem el document XML generat por la sortida estandard
		marshaller.marshal(pantalones, System.out);
		
		FileOutputStream fos = new FileOutputStream(PANTALONES_XML_FILE);
		//guardem l'objecte serializat en un document XML
		marshaller.marshal(pantalones, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Deserialitzem a partir de un document XML
		Pantalones PantalonesAux = (Pantalones) unmarshaller.unmarshal(new File(PANTALONES_XML_FILE));
		System.out.println("********* Pantalons carregat desde fitxer XML***************");
		//Mostrem l'objeto Java obtingut
		marshaller.marshal(PantalonesAux, System.out);
                
		
	}
	
	private static Pantalones omplePantalones(){
		
		String[] tiposPantalones = {"Slim", "Pitillo", "Chino"};
                String[] marca = {"Bershka", "Levis", "Fila"};
                String[] tamany = {"S", "M", "L"};
		int[] numeroPantalon = {34, 38, 33};
                String[] detalls = {"Forats","Simples","Complexos"};
		Pantalon[] arrayPantalones = new Pantalon[3];
		
		for(int i=0; i<3; i++){
                        arrayPantalones[i] = new Pantalon();
                        arrayPantalones[i].setTiposPantalones(tiposPantalones[i]);
                        arrayPantalones[i].setMarca(marca[i]);
                        arrayPantalones[i].setTamany(tamany[i]);
                        arrayPantalones[i].setNumeroPantalon(numeroPantalon[i]);
			arrayPantalones[i].setId(i+1);	
                        arrayPantalones[i].setDetalls(detalls[i]);
		}
		
		Pantalones pantalones = new Pantalones();
		pantalones.setPantalones(arrayPantalones);
		
		return pantalones;
	}
       
 
}