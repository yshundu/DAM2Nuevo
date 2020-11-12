package act4llegirxml;
/**
 *
 * @author Yang
 */
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
public class Act4LlegirXML {
 /*
Has de codificar un programa que llegeixi un arxiu xml i mostri per pantalla tots
els nodes que conté el document i, per a cada node, ha de mostrar els seus atributs
(i valors) si en té i per a cada node fill, els seus atributs (i valors) si en té i,
 per a cada node fill, ....(el mateix, haureu d’usar una funció/mètode recursiva)
De cada node volem veure el tipus, i el nom. De cada atribut el nom i el valor.
*/
 
    public static boolean nousElements(Element node){
        
        
        System.out.println("Node name: " + node.getNodeName());
        System.out.println("Node Value: " + node.getTextContent());

        
        if (node.hasAttributes()) {
             NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("-- Atributo: " + attributes.item(i).getNodeName() + ", con value: " + attributes.item(i).getTextContent());
            }
        }
        if (node.hasChildNodes()) {
            NodeList fills = node.getChildNodes();
            for (int i = 0; i < fills.getLength(); i++) {
                Node nodo = fills.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
  
                    nousElements((Element)nodo);
                }
            }        
        }

        
        return false;
    }
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
 
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("C:\\Users\\Alumne\\Desktop\\alumnes.xml"));
 
            Element nodeArrel = documento.getDocumentElement();

            nousElements(nodeArrel);
    }
 
}