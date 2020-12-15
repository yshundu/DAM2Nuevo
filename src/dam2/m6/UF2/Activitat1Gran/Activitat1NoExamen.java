package dam2.m6.UF2.Activitat1Gran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yangshun Zhan Du
 */
public class Activitat1NoExamen {
     static Connection con = null;
     static Statement stmt;
     static Scanner sc = new Scanner(System.in);
     public static void main(String[] args) throws ClassNotFoundException, SQLException{
         int sortida = 0,opcio;
        String nom;
        String dni;
        String dataNaixement;
        String adreca;
        String sexe;
        int codiPostal;
        //Fem la connexió amb la base de dades
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
         //Condicional del menú
         while (sortida != 1) {
             System.out.println("Introdueix opció: ");
             System.out.println("1. Insertar alumne");
             System.out.println("2. Modificar alumne ");
             System.out.println("3. Eliminar alumne ");
             System.out.println("4. Insertar població ");
             System.out.println("5. Eliminar població ");
             System.out.println("6. Llistar alumne ");
             System.out.println("7. Llistar tots els alumnes ");
             System.out.println("8. Llistar poblacio ");
             System.out.println("9. Llistar totes les poblacions ");
             System.out.println("0. Acabar programa ");
             
             opcio = sc.nextInt();
             sc.nextLine();
             
             //Agafem els valors per afegir el alumne i
             //utilitzem el trim per no agafar espais en blanc
             switch (opcio) {
                 case 1:
                    System.out.println("Introdueix el nom: ");
                    nom = sc.nextLine().trim();

                    System.out.println("Introdueix DNI: ");
                    dni = sc.nextLine().trim();

                    System.out.println("Introdueix data de naixement: (YYYY-MM-DD)");
                    dataNaixement = sc.nextLine().trim();

                    System.out.println("Introdueix la adreça: ");
                    adreca = sc.nextLine().trim();
                    
                    System.out.println("Introdueix sexe: (Home o Dona)");
                    sexe = sc.nextLine().trim();
                    
                    System.out.println("Introdueix codi postal (5 nombres): ");
                    codiPostal = sc.nextInt();
                    //Utilitzem el metode creat
                    try {
                    insertaAlumne(nom,dni,dataNaixement,adreca,sexe,codiPostal);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Falla en la inserció de dades.");
                        System.out.println("Comprova que existeix el codi postal en la base de dades POBLACIONS.");
                    }
                     break;
                 case 2:
                     System.out.println("Introdueix el DNI de la persona a modificar: ");
                     String dniModificacio = sc.nextLine();
                     //Utilitzem el metode creat
                     try {
                         //Utilitzem el metode creat
                         modificaAlumne(dniModificacio);
                     }catch(Exception e){
                         e.printStackTrace();
                     }
                     break;
                 case 3:
                     System.out.println("Introdueix el DNI de la persona a eliminar: ");
                     String dniEliminar = sc.nextLine();
                     //Utilitzem el metode creat
                     try {
                         //Utilitzem el metode creat
                         eliminaAlumne(dniEliminar);
                     }catch(Exception e){
                         e.printStackTrace();
                     }
                     break;
                 case 4:
                     String poblacioAux;
                     int codiPostalAux;
                    System.out.println("Introdueix el nom de la poblacio: ");
                    poblacioAux = sc.next().trim();

                    System.out.println("Introdueix codi postal: (5 valors)");
                    codiPostalAux = sc.nextInt();
                    //Utilitzem el metode creat
                    insertaPoblacio(codiPostalAux, poblacioAux);
                     break;
                case 5:
                    int codiPostalEliminar;
                    System.out.println("Introdueix el codi postal de la poblacio a eliminar:"
                            + " (Es eliminaran tots els alumnes amb codi postal associat)");
                    codiPostalEliminar = sc.nextInt();
                    //Utilitzem el metode creat
                    eliminaPoblacio(codiPostalEliminar);
                     break;
                case 6:
                    String dniLlistar;
                    System.out.println("Introdueix el DNI de la persona a llistar: ");
                    dniLlistar = sc.nextLine();
                    llistaAlumne(dniLlistar);
                    break;
                case 7:
                    System.out.println("Llistant tots els alumnes...");
                    llistaAlumnesTots();
                    break;
                case 8:
                    int codiPostalLlista;
                    System.out.println("Introdueix codi postal per llistal població: ");
                    codiPostalLlista = sc.nextInt();
                    llistaPoblacio(codiPostalLlista);
                    break;
                case 9:
                    System.out.println("Llistant totes les poblacions");
                    llistaPoblacioTots();
                    break;
                case 0:
                    //Activem la condicional per sortir del bucle i acabar programa.
                     sortida = 1;
                     System.out.println("Programa acabat.");
                     con.close();
                     sc.close();
                     stmt.close();
                     break;
                 default:
                     System.out.println("Opció no vàlida");
                     break;
                         
                }
            }  
         }
        //Metode que introdueix un alumne a la base de dades
        private static void insertaAlumne(String nom, String dni, String dataNaixement, String adreca, String sexe, int codiPostal){
                  try {
                      //Creem la connexio i fem la sintaxis sql
                         stmt = con.createStatement();
                         stmt.execute("INSERT INTO alumnes VALUES ('"+ nom +"','"+dni+"','"+dataNaixement+
                                 "','"+adreca+"','"+sexe+"','"+codiPostal+"')");
                    } catch(Exception e){
                        System.out.println("Falla en la inserció de dades.");
                        System.out.println("Comprova que existeix el codi postal en la base de dades POBLACIONS.");
                        e.printStackTrace();
                    }
              }
        //Metode per modificar un camp o varies d'un alumne
        private static void modificaAlumne(String dni){
            //Comprovem si existeix el alumne
            try {
            ResultSet resultSet;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM alumnes WHERE dni = '" + dni +"'");
             
             comprovar = resultSet.next();
             
             if (comprovar == false) {
                 System.out.println("No existeix el alumne");
             } else {
            stmt = (Statement) con.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM alumnes WHERE dni = '" + dni +"'");
            String nom = null;
            String dataNaixement = null;
            String adreca = null;
            String sexe = null;
            String codiPostal = null;
            while(resultSet.next()){
            System.out.println("Nom["+resultSet.getString(1)+"]: ");
            nom = sc.nextLine();
            //Comprovem que si no inserim res no faci cap canvi
            if (nom.length() == 0){
                nom = resultSet.getString(1);
            }
            //System.out.println("DNI["+resultSet.getString(2)+"]. ");
            
            System.out.println("data Naixement["+resultSet.getString(3)+"]: (YYYY-MM-DD) ");
            dataNaixement = sc.nextLine();
            if (dataNaixement.length() == 0){
                dataNaixement = resultSet.getString(3);
            }
            
            System.out.println("Adreça["+resultSet.getString(4)+"]: ");
            adreca = sc.nextLine();
            if (adreca.length() == 0){
                adreca = resultSet.getString(4);
            }
            
            System.out.println("sexe["+resultSet.getString(5)+"]:(Home o Dona) ");
            sexe = sc.nextLine();
            if (sexe.length() == 0){
                sexe = resultSet.getString(5);
            }
            
            System.out.println("codiPostal["+resultSet.getString(6)+"]:(5 valors) ");
            codiPostal = sc.nextLine();
            if (codiPostal.length() == 0){
                codiPostal = resultSet.getString(6);
                //stmt.execute("UPDATE alumnes SET codiPostal = '" + codiPostal + "' WHERE dni='"+dni+"';");
            }
            }
            stmt.execute("UPDATE alumnes SET nom='"+nom+"',dataNaixement='"+dataNaixement+
                    "',adreca='"+adreca+"',sexe ='"+sexe+ "',codiPostal = " + codiPostal+
                    " WHERE dni='"+dni+"';");
            }
            } catch(Exception e){
                   e.printStackTrace();
              }
         }
        //Metode per eliminar un alumne
        private static void eliminaAlumne(String dniEliminar){
         try {
             ResultSet resultSet;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM alumnes WHERE dni = '" + dniEliminar +"'");
             
             comprovar = resultSet.next();
             
             if (comprovar == false) {
                 System.out.println("No existeix el alumne");
             } else {
                 stmt.executeUpdate("DELETE FROM alumnes WHERE id ='"+ dniEliminar+"'");
                 System.out.println("Alumne eliminat correctament.");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
        }
        //Metode per inserir una poblacio a la base de dades
        private static void insertaPoblacio(int codiPostal, String poblacio){
            try {
                    stmt = con.createStatement();
                    stmt.execute("INSERT INTO poblacions VALUES ('"+codiPostal+"','"+poblacio+"')");
            } catch(Exception e){
                    System.out.println("Falla en la inserció de dades.");
                    System.out.println("Comprova la longitud del codi postal");
                     e.printStackTrace();
                    }
        }
        //Metode per eliminar una poblacio i si hi han alumnes amb aquell 
        //codipostal seran eliminades depenent de l'usuari
        private static void eliminaPoblacio (int codiPostal) {
            try {
             ResultSet resultSet;
             ResultSet resultSet2;
             int opcion=0;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM poblacions WHERE codiPostal = '"+codiPostal+"'");
             comprovar = resultSet.next();
             //Comprovem que existeix el codi postal
             if (comprovar == false) {
                 System.out.println("No existeix la població");
             } else {
                 System.out.println("Els seguents alumnes seran eliminades, vols continuar?");
                 resultSet2 = stmt.executeQuery("SELECT * FROM alumnes WHERE codiPostal ='"+codiPostal+"'");
                 //Mostrem els alumnes que seran eliminades
                 while(resultSet2.next()){
                     System.out.println(resultSet2.getString(1));
                 }
                 //Confirmació per eliminar
                 System.out.println("Si (1) o No (2)?");
                 opcion = sc.nextInt();
                 if (opcion==1){
                 stmt.executeUpdate("DELETE FROM poblacions WHERE codiPostal ='"+codiPostal+"'");
                 System.out.println("Població eliminada correctament.");
                 } else if (opcion==2){
                 System.out.println("Modificació revertida correctament.");    
                 } else {
                     System.out.println("Opció no vàlida, siusplau introdueix un"
                             + " 1 en cas de sí o introdueix un 2 en cas de no.");
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
        }
        //Metode per llistar 1 alumne
        private static void llistaAlumne (String dni) {
             try {
             ResultSet resultSet;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM alumnes WHERE dni = '" + dni +"'");
             
             comprovar = resultSet.next();
             
             if (comprovar == false) {
                 System.out.println("No existeix el alumne");
             } else {
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM alumnes WHERE dni = '"+dni+"'");
             System.out.println("NOM-------DNI----DATANAIXEMENT--ADREÇA------SEXE---CODIPOSTAL");
             
             while (resultSet.next()){
                 System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3)+
                         "  "+resultSet.getString(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6)+"  ");
             }
             }
                  } catch (Exception e) {
             e.printStackTrace();
         }
        } 
        //Metode per llistar totes les alumnes
        private static void llistaAlumnesTots() {
            try {
             ResultSet resultSet;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM alumnes");
             System.out.println("NOM-------DNI----DATANAIXEMENT--ADREÇA------SEXE---CODIPOSTAL");
             
             while (resultSet.next()){
                 System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3)+
                         "  "+resultSet.getString(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6)+"  ");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
        }
        //Metode per llistar 1 poblacio
        private static void llistaPoblacio(int codiPostal){
            try {
             ResultSet resultSet;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM poblacions WHERE codiPostal = '" + codiPostal +"'");
             
             comprovar = resultSet.next();
             
             if (comprovar == false) {
                 System.out.println("No existeix la població");
             } else {
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM poblacions WHERE codiPostal = '"+codiPostal+"'");
             System.out.println("CP-------POBLACIO");
             
             while (resultSet.next()){
                 System.out.println(resultSet.getString(1)+"   "+resultSet.getString(2)+"  ");
             }
             }
            } catch (Exception e) {
             e.printStackTrace();
         }
        }
        //Metode per llistar totes les poblacions
        private static void llistaPoblacioTots(){
         try {
             ResultSet resultSet;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM poblacions");
             System.out.println("CP-------POBLACIO");
             
             while (resultSet.next()){
                 System.out.println(resultSet.getString(1)+"   "+resultSet.getString(2)+"  ");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
        }
        }

