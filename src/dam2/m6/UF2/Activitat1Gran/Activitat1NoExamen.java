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
        String url = "jdbc:mysql://localhost:3306/activitat1_m6";
        String usuari = "root";
        String password = "";
        
        System.out.println("Prova de connexió: ");
         try {
            //Carreguem el controlador en memòria
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    url, usuari, password);
        }
         catch (Exception e) {
         e.getMessage();
         }
         finally {
                con.close();
        }
         
         while (sortida != 1) {
             System.out.println("Introdueix opció: ");
             System.out.println("1. Insertar alumne");
             System.out.println("2. Modificar alumne ");
             System.out.println("3. Eliminar alumne ");
             System.out.println("4. Acabar programa ");
             
             opcio = sc.nextInt();
             
             switch (opcio) {
                 case 1:
                    System.out.println("Introdueix el nom: ");
                    nom = sc.nextLine();

                    System.out.println("Introdueix DNI: ");
                    dni = sc.nextLine();

                    System.out.println("Introdueix data de naixement: (DD/MM/YYYY)");
                    dataNaixement = sc.nextLine();

                    System.out.println("Introdueix la adreça: ");
                    adreca = sc.nextLine();

                    System.out.println("Introdueix sexe: ");
                    sexe = sc.nextLine();

                    System.out.println("Introdueix codi postal: ");
                    codiPostal = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introdueix poblacio: ");
                    poblacio = sc.nextLine();
                    
                    insertaAlumne(nom,dni,dataNaixement,adreca,sexe,codiPostal,poblacio);
                     break;
                 case 2:
                     break;
                 case 3:
                     break;
                 case 4:
                     sortida = 1;
                     break;
                 default:
                     System.out.println("Opció no vàlida");
                     break;
                         
                }
            }  
         }
     
        private static void insertaAlumne(String nom, String dni, String dataNaixement, String adreca, String sexe, int codiPostal, String poblacio){
                  Statement stmt;
                  try {
                         stmt = con.createStatement();
                         stmt.execute("INSERT INTO alumnes VALUES ('" + nom + "','" + dni + "','" + dataNaixement +
                                 "','" + adreca + "','" + sexe + "','" + codiPostal + "','" + poblacio + "','");
                    } catch(Exception e){
                        e.getMessage();
                    }
              }
     }
