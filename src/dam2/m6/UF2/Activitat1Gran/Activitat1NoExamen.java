package dam2.m6.UF2.Activitat1Gran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
     static Scanner sc = new Scanner(System.in);
     public static void main(String[] args) throws ClassNotFoundException, SQLException{
         int sortida = 0,opcio;
        String nom;
        String dni;
        String dataNaixement;
        String adreca;
        String sexe;
        int codiPostal;

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
             System.out.println("4. Insertar població ");
             System.out.println("5. Eliminar població ");
             System.out.println("6. Acabar programa ");
             
             opcio = sc.nextInt();
             sc.nextLine();
             
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
                     try {
                         modificaAlumne(dniModificacio);
                     }catch(Exception e){
                         e.printStackTrace();
                     }
                     break;
                 case 3:
                     System.out.println("Introdueix el DNI de la persona a eliminar: ");
                     String dniEliminar = sc.nextLine();
                     try {
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
                    
                    insertaPoblacio(codiPostalAux, poblacioAux);
                     break;
                case 5:
                    int codiPostalEliminar;
                    System.out.println("Introdueix el codi postal de la poblacio a eliminar:"
                            + " (Es eliminaran tots els alumnes amb codi postal associat)");
                    codiPostalEliminar = sc.nextInt();
                    eliminaPoblacio(codiPostalEliminar);
                     break;
                case 6:
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
     
        private static void insertaAlumne(String nom, String dni, String dataNaixement, String adreca, String sexe, int codiPostal){
                  try {
                         stmt = con.createStatement();
                         stmt.execute("INSERT INTO alumnes VALUES ('"+ nom +"','"+dni+"','"+dataNaixement+
                                 "','"+adreca+"','"+sexe+"','"+codiPostal+"')");
                    } catch(Exception e){
                        System.out.println("Falla en la inserció de dades.");
                        System.out.println("Comprova que existeix el codi postal en la base de dades POBLACIONS.");
                        e.printStackTrace();
                    }
              }
        
        private static void modificaAlumne(String dni){
            try {
            ResultSet resultSet;
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
            } catch(Exception e){
                   e.printStackTrace();
              }
         }
        
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
        
        private static void eliminaPoblacio (int codiPostal) {
            try {
             ResultSet resultSet;
             ResultSet resultSet2;
             int opcion=0;
             boolean comprovar;
             stmt = (Statement) con.createStatement();
             resultSet = stmt.executeQuery("SELECT * FROM poblacions WHERE codiPostal = '"+codiPostal+"'");
             comprovar = resultSet.next();
             
             if (comprovar == false) {
                 System.out.println("No existeix la població");
             } else {
                 System.out.println("Els seguents alumnes seran eliminades, vols continuar?");
                 resultSet2 = stmt.executeQuery("SELECT * FROM alumnes WHERE codiPostal ='"+codiPostal+"'");
                 
                 while(resultSet2.next()){
                     System.out.println(resultSet2.getString(1));
                 }
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
        }

