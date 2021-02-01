/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat4;

import java.util.Scanner;

/**
 *
 * @author Yang
 */
public class Act4Ap3B {
    public static int maximComuDivisor(int valor1, int valor2) {
        if (valor2 == 0) {
            return valor1;
        } else {
            return maximComuDivisor(valor2, valor1 % valor2);
        }
    }
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int valor1 = 15;
        int valor2 = 3;
        //System.out.println("Introdueix el valor 1:");
        //valor1 = sc.nextInt();
        //System.out.println("Introdueix el valor 2:");
        //valor2 = sc.nextInt();
        int resultat = maximComuDivisor(valor1, valor2);
        System.out.println("El resultat del maxim comu divisor entre"
                + " "+valor1+ " y valor "+valor2+ " es: "+ resultat);
    }
}
