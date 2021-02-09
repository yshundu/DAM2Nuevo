/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m6.UF2.ExamenUF2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class ExamenUF2M6 {
    static Connection con = null;
     static Statement stmt;
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        int sortida=0, opcio;
        String nom;
        String contrasenya;
        String pregunta;
        String resposta;
        
                //Fem la connexió amb la base de dades
         try {
            String url = "jdbc:mysql://localhost:3306/examenuf2";
            String usuari = "root";
            String password = "";
            //Carreguem el controlador en memòria
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    url, usuari, password);
        }
         catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
         }
         //Fem una condicional per entrar en bucle
         while (sortida != 1) {
             System.out.println("Escull opció: ");
             System.out.println("1-Crear");
             System.out.println("2-Login");
             System.out.println("3-Reset");
             System.out.println("4-Sortir");
             System.out.println("Opció?");
             opcio = sc.nextInt();
             sc.nextLine();
             
             switch (opcio) {
                 case 1:
                    System.out.println("Has escollit crear, insereix la informació"
                            + "que es demana: ");
                    System.out.println("Usuari?");
                    nom = sc.nextLine().trim();

                    System.out.println("Contrasenya?");
                    contrasenya = sc.nextLine().trim();

                    System.out.println("Pregunta?");
                    pregunta = sc.nextLine().trim();

                    System.out.println("Resposta?");
                    resposta = sc.nextLine().trim();
                    //Cridem a la funcio
                    try {
                        creaUsuari(nom,contrasenya,pregunta,resposta);
                    } catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Falla en la inserció de dades.");
                    }
                     break;
                     
                 case 2:
                    System.out.println("Has escollit login, insereix la informació"
                    + "que es demana: ");
                    System.out.println("Usuari?");
                    nom = sc.nextLine().trim();
                    
                    System.out.println("Contrasenya?");
                    contrasenya = sc.nextLine().trim();
                    
                    try {
                        loginUsuari(nom,contrasenya);
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Falla en la consulta.");
                    }
                     break;
                     
                 case 3:
                    System.out.println("Has escollit reset, insereix la informació"
                    + "que es demana: ");
                    System.out.println("Usuari?");
                    nom = sc.nextLine().trim();
                    try {
                    resetUsuari(nom);
                    } catch (Exception e) {
                        System.out.println("Falla en la consulta.");
                    }
                     break;
                 case 4:
                     sortida=1;
                     System.out.println("Programa acabat.");
                     con.close();
                     sc.close();
                     stmt.close();
                     break;
                 default:
                     break;
             }
         }
    }

    private static void creaUsuari(String nom, String contrasenya, String pregunta, String resposta) {
        try {
            //Creem la connexio i fem la sintaxis sql
                stmt = con.createStatement();
                stmt.execute("INSERT INTO usuaris VALUES ('"+ nom +"','"+contrasenya+"','"+pregunta+
                 "','"+resposta+"')");
                System.out.println("Usuari creat");
                } catch(Exception e){
                        System.out.println("Falla en la inserció de dades.");
                        System.out.println("ERROR: Usuari ja existeix");
                        e.printStackTrace();
                    }
    }

    private static void loginUsuari(String nom, String contrasenya) {
        //Comprovem si existeix i se correcte procedeix a fer la comprovacio
        try {
            ResultSet resultSet;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM usuaris WHERE contrasenya = '"+ contrasenya +"' AND usuari = '" + nom +"'");
             
             comprovar = resultSet.next();
             
             if (comprovar == false) {
                 System.out.println("ERROR: login incorrecte\n");
             } else {
                 System.out.println("Login correcte\n");
             }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void resetUsuari(String nom) {
        //Utilitzem dos resultset per poder fer una doble comprovacio
        //
        try {
          ResultSet resultSet;
          ResultSet resultSet2;
          boolean comprovar;
          stmt = (Statement) con.createStatement();
          resultSet = stmt.executeQuery("SELECT * FROM usuaris WHERE usuari = '" + nom +"'");

          comprovar = resultSet.next();

         if (comprovar == false) {
              System.out.println("No existeix el usuari");
          } else {
           stmt = (Statement) con.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM usuaris WHERE usuari = '" + nom +"'");
            String resposta;
            String nContrasenya;
            while(resultSet.next()){
                System.out.println(resultSet.getString(3));
                resposta = sc.nextLine();
                resultSet2 = stmt.executeQuery("SELECT * FROM usuaris WHERE usuari = '" + nom +"' AND resposta = '"+resposta+"'");
                comprovar = resultSet2.next();
                
                if (comprovar == false) {
                    System.out.println("ERROR: Reset incorrecte");
                } else {
                    System.out.println("Introdueix nova contrasenya:");
                    nContrasenya = sc.nextLine();
                    stmt.execute("UPDATE usuaris SET contrasenya='"+nContrasenya+"' WHERE usuari = '"+nom+"'");
                }
            }
            }
        } catch (Exception e) {

        }
    }
}
