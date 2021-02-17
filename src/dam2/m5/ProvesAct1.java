/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m5;

import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class ProvesAct1 {
    
    static int Comptador (int x, int y)
    {
        Scanner entrada = new Scanner(System.in);
        int num, c = 0;
        if ((x>0)&&(y>0))
        {
            System.out.println("Escriu un número");
            num = entrada.nextInt();
            if ((num>=x)&&(num<=y))
            {
                System.out.println("\tNúmero en el rang");
                c++;
            }
            else
                System.out.println("\tNúmero fora del rang");
        }
        else
            c = -1;
        entrada.close();
        return c;
    }
    
}
