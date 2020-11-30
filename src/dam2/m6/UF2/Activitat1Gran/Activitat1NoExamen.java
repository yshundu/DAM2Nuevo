/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m6.UF2.Activitat1Gran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Yang
 */
public class Activitat1NoExamen {
     public static void main(String[] args) throws ClassNotFoundException, SQLException{
         Scanner sc = new Scanner(System.in);
         int opcio, id;
        String nom;
        String dni;
        String dataNaixement;
        String adreca;
        String sexe;
        int codiPostal;
        String poblacio;
        
        Connection con = null;
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
        
     }
}
