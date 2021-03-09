/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF3.Activitat1;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Yangshun Z. Du Raul G. Perez
 */
public class Activitat1 {
    public static void main (String[] args) {
        String nomMaquina;
        Scanner sc = new Scanner(System.in);
        InetAddress dir = null;
        
        try {
            System.out.println("Introdueix un nom de màquina o adreça IP: ");
                    nomMaquina = sc.nextLine();
                    dir = InetAddress.getByName(nomMaquina);
                    provaTots(dir);
                    
            } catch (Exception e) {
            e.printStackTrace();
        }
}

    private static void provaTots(InetAddress dir) throws IOException {
            InetAddress dir2;
            System.out.println("\tMètode getByName(): "+dir);
		try {
                    dir2 = InetAddress.getLocalHost();
                    System.out.println("\tMètode getLocalHost(): "+dir2);
		} catch (Exception e) {e.printStackTrace();}
		
		//FEM SERVIR METODES DE LA CLASSE
                //Per veure si en 0,02 segons es fa la connexió
                System.out.println("\tMétode isReachable(): "+dir.isReachable(50));
		System.out.println("\tMètode getHostName(): "+dir.getHostName());
		System.out.println("\tMètode getHostAddress(): "+dir.getHostAddress());
		System.out.println("\tMètode toString(): "+dir.toString());
		System.out.println("\tMètode getCanonicalHostName(): "+dir.getCanonicalHostName());
    }
}
