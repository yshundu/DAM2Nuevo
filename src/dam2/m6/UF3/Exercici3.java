/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m6.UF3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
/**
 *
 * @author Alumne
 */
public class Exercici3 {
    public static void main (String[] args) throws XMLDBException {
        //Driver per a eXist
        String driver = "org.exist.xmldb.DatabaseImpl";
        //Col·lecció
        Collection col = null;
        //URI col·lecció
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/";
        //Usuari
        String usu = "admin";
        //Contrasenya
        String usuPass = "alumne";
        //Connexió a la base de dades
        try {
            //Carrega el driver
            Class cl = Class.forName(driver);
            //Instància de la BD
            Database database = (Database) cl.newInstance();
            //Registre del driver
            DatabaseManager.registerDatabase(database);
        } catch (Exception e) {
            System.out.println("Error en inicialitzar la base de dades eXist");
            e.printStackTrace();
        }
        

        //Conversió a numèric
        
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        
        if (col==null) {
            System.out.println("*** LA COL·LECCIÓ NO EXISTEIX ***");
        }
        System.out.println("Escriu un departament: ");
        String s = null;
        //Entrada estandard
        try {
            BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
            s = in.readLine();
        } catch (IOException e) {
            System.out.println("Error en llegir");
            e.printStackTrace();
        }
        
        int dep = Integer.parseInt(s);
        
        XPathQueryService servei = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        ResourceSet result = servei.query("for $em in /departamentos/DEP_ROW[DEPT_NO=20] return $em");
        
        //Recorrer les dades del recurs
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources())
            System.out.println("LA CONSULTA NO TORNA RES");
        
        while (i.hasMoreResources()) {
           Resource r = i.nextResource();
            System.out.println((String)r.getContent());
        }
        //S'esborra
        col.close();
    }
}
