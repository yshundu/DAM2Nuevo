/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m6.UF2.Activitat1Gran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Yang
 */
public class Activitat1NoExamen {
     static Connection con = null;
     static Statement stmt;
     public static void main(String[] args) throws ClassNotFoundException, SQLException{
         Scanner sc = new Scanner(System.in);
         int sortida = 0,opcio;
        String nom;
        String dni;
        String dataNaixement;
        String adreca;
        String sexe;
        int codiPostal;
        String poblacio;
        
        //Connection con = null;

         try {
            String url = "jdbc:mysql://localhost:3306/m6uf2";
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
         
         while (sortida != 1) {
             System.out.println("Introdueix opció: ");
             System.out.println("1. Insertar alumne");
             System.out.println("2. Modificar alumne ");
             System.out.println("3. Eliminar alumne ");
             System.out.println("4. Acabar programa ");
             
             opcio = sc.nextInt();
             sc.nextLine();
             
             switch (opcio) {
                 case 1:
                    System.out.println("Introdueix el nom: ");
                    nom = sc.nextLine();

                    System.out.println("Introdueix DNI: ");
                    dni = sc.next();
                    sc.nextLine();

                    System.out.println("Introdueix data de naixement: (YYYY-MM-DD)");
                    dataNaixement = sc.nextLine();

                    System.out.println("Introdueix la adreça: ");
                    adreca = sc.nextLine();
                    
                    System.out.println("Introdueix sexe: ");
                    sexe = sc.next();
                    //sc.nextLine();
                    System.out.println("Introdueix codi postal (5 nombres): ");
                    codiPostal = sc.nextInt();
                    try {
                    insertaAlumne(nom,dni,dataNaixement,adreca,sexe,codiPostal);
                    }
                    catch (Exception e){
                        System.out.println("Falla en la inserció de dades.");
                        System.out.println("Comprova que existeix el codi postal en la base de dades POBLACIONS.");
                        e.printStackTrace();
                    }
                     break;
                 case 2:
                     System.out.println("Introdueix el DNI de la persona a modificar: ");
                     String dniModificacio = sc.next();
                     try {
                         modificaAlumne(dniModificacio);
                     }catch(Exception e){
                         e.printStackTrace();
                     }
                     break;
                 case 3:
                     break;
                 case 4:
                     sortida = 1;
                     System.out.println("Programa acabat.");
                     break;
                 default:
                     System.out.println("Opció no vàlida");
                     break;
                         
                }
            }  
         }
     
        private static void insertaAlumne(String nom, String dni, String dataNaixement, String adreca, String sexe, int codiPostal){
                  try {
                         stmt = con.createStatement();
                         stmt.execute("INSERT INTO alumnes VALUES ('" + nom + "',' " + dni + "',' " + dataNaixement +
                                 "',' " + adreca + "',' " + sexe + "',' " + codiPostal + "')");
                    } catch(Exception e){
                        e.printStackTrace();
                    }
              }
        private static void modificaAlumne(String dni){
            try {
                stmt = con.createStatement();
                    stmt.execute();  
                    } catch(Exception e){
                        e.printStackTrace();
                    }
        }
     }
