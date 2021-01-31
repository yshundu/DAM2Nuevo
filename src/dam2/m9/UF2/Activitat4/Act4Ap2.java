/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat4;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author Yang
 */
public class Act4Ap2 {
    
    static int[] arrayContador = {0, 0, 0, 0};

    public static void main(String[] args) {
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        int[] numerosAleatoris = new int[20];

        metodeBombolla[] arrayBombollas = new metodeBombolla[4];

        for (int i = 0; i < numerosAleatoris.length; i++) {
            numerosAleatoris[i] = (int) (Math.random() * 9) + 1;
        }

        System.out.println(Arrays.toString(numerosAleatoris));

        int contadorX = 0;
        for (int i = 0; i < arrayBombollas.length; i++) {
            int[] arrayAux = new int[numerosAleatoris.length / 4];
            for (int j = 0; j < arrayAux.length; j++) {
                arrayAux[j] = numerosAleatoris[contadorX];
                contadorX++;
            }
            metodeBombolla bombolla = new metodeBombolla(arrayAux, i);
            arrayBombollas[i] = bombolla;
        }

        