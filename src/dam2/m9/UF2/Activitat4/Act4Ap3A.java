/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat4;

/**
 *
 * @author Yang
 */
public class Act4Ap3A {
    //Metode per elevar al cuadrat en recursiu
    public static long elevadoX(long exponente, long base){
        double calcul = java.lang.Math.cos(54879854);
        int comprovar = 0;
        if(exponente == 0){
            comprovar = 1;
        }
        
        if(comprovar == 1){
            return 1;
        } else {
            return elevadoX(exponente-1, base) * base;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(elevadoX(55,15));
    }
}
